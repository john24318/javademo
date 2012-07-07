package sn.core.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sn.core.service.StockService;

/**
 * Google股价服务
 * 
 * @author 王耀
 * 
 */
public class GoogleStockService implements StockService {

    private static Log log = LogFactory.getLog(GoogleStockService.class);

    private final static String googleFinanceUrl = "http://finance.google.com/finance/info?q=";

    /**
     * 发送http请求并返回内容
     * 
     * @param urlStr
     * @return
     */
    private String sendRequest(String urlStr) {
        StringBuffer sb = new StringBuffer();
        HttpURLConnection httpConnection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlStr);
            httpConnection = (HttpURLConnection) url.openConnection();
            reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            String str = null;
            while (null != (str = reader.readLine())) {
                sb.append(str);
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }

            if (null != httpConnection) {
                httpConnection.disconnect();
            }
        }

        return sb.toString();
    }

    /**
     * 解析返回的json数据
     * 
     * @param response
     * @param stockPriceArray
     */
    private void parseResponse(String response, float[] stockPriceArray) {
        response = response.replaceAll("//", ""); // 去掉字串值中的/字符
        JSONArray jsonArray = JSONArray.fromObject(response);

        if (null != jsonArray) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObj = JSONObject.fromObject(jsonArray.get(i));
                stockPriceArray[i] = (float) jsonObj.getDouble("l");
            }
        }
    }

    /**
     * 实时获取股票价格
     */
    public float[] price(String[] stockCodeArray) {
        float[] stockPriceArray = new float[stockCodeArray.length];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stockCodeArray.length; i++) {
            sb.append(stockCodeArray[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);

        String response = sendRequest(googleFinanceUrl + sb.toString());
        parseResponse(response, stockPriceArray);

        return stockPriceArray;
    }

    /**
     * 实时获取股票价格
     */
    public float price(String stockCode) {
        return price(new String[] { stockCode })[0];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] stockCodeArray = { "SHE:000069", "SHE:000068" };
        StockService service = new GoogleStockService();
        float[] prices = service.price(stockCodeArray);
        System.out.println(Arrays.toString(prices));
        System.out.println(service.price("SHE:000069"));
    }

}
