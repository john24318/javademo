package sn.core.task;

import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sn.base.util.Constants;
import sn.base.util.DateUtil;
import sn.core.persistence.dao.SnNoticeDao;
import sn.core.persistence.dao.SnStockDao;
import sn.core.persistence.dao.impl.SnNoticeDaoImpl;
import sn.core.persistence.dao.impl.SnStockDaoImpl;
import sn.core.persistence.model.SnNotice;
import sn.core.persistence.model.SnStock;
import sn.core.service.StockService;
import sn.core.service.impl.GoogleStockService;

public class MakeNoticeTask extends TimerTask {
    private static Log log = LogFactory.getLog(MakeNoticeTask.class);
    private static Hashtable<String, Float> stockPriceCache = new Hashtable<String, Float>();
    private SnStockDao stockDao = new SnStockDaoImpl();
    private SnNoticeDao noticeDao = new SnNoticeDaoImpl();
    private StockService stockService = new GoogleStockService();

    @Override
    public void run() {
        log.debug("生成通知开始于：" + DateUtil.convertDateToString(new Date()));

        // 更新股票价格
        updateStockPriceCache();

        // 生成通知
        makeNotice();

        log.debug("生成通知完成于：" + DateUtil.convertDateToString(new Date()));
    }

    /**
     * 更新股票价格缓存
     */
    private void updateStockPriceCache() {
        /* 由于http get请求有长度限制，因此查询股票价格需要分多次完成 */
        String[] stockCodeArray = stockDao.getStockCode();
        int total = stockCodeArray.length;
        int times = (total + Constants.MAX_STOCK_QUERY_NUM - 1) / Constants.MAX_STOCK_QUERY_NUM; // 查询次数
        String[] stocks = null;

        for (int j = 0; j < times; j++) {
            if (j < times - 1) {
                stocks = Arrays.copyOfRange(stockCodeArray, j * Constants.MAX_STOCK_QUERY_NUM, (j + 1) * Constants.MAX_STOCK_QUERY_NUM);
            } else {
                stocks = Arrays.copyOfRange(stockCodeArray, j * Constants.MAX_STOCK_QUERY_NUM, total);
            }

            float[] prices = stockService.price(stocks);
            for (int k = 0; k < stocks.length; k++) {
                stockPriceCache.put(stocks[k], prices[k]);
            }
        }
    }

    /**
     * 生成通知
     */
    private void makeNotice() {
        StringBuffer buyStockIds = new StringBuffer("0");
        StringBuffer sellStockIds = new StringBuffer("0");
        SnNotice notice = new SnNotice();
        notice.setFlag(Constants.NOTICE_FLAG_DEFAULT);
        notice.setEmailResult(Constants.NOTICE_RESULT_FAILURE);
        notice.setSmsResult(Constants.NOTICE_RESULT_FAILURE);
        notice.setCreateTime(new Date());
        List<SnStock> list = stockDao.getUnNoticeStock();

        for (Iterator<SnStock> it = list.iterator(); it.hasNext();) {
            SnStock stock = it.next();
            float price = stockPriceCache.get(stock.getStockCode());

            // 生成买入通知
            if (Constants.STOCK_FLAG_DEFAULT == stock.getBuyNoticeFlag().intValue() && price <= stock.getMinPrice().floatValue()) {
                notice.setUserId(stock.getUserId());
                notice.setStockId(stock.getStockId());
                notice.setTitle(Constants.NOTICE_TITLE_BUY);
                notice.setContent(stock.getStockName() + "（" + stock.getStockCode() + "）当前价格为" + price + "，低于或等于您的买入价格" + stock.getMinPrice()
                        + "，请及时买入！");

                if (noticeDao.add(notice)) {
                    buyStockIds.append(",").append(stock.getStockId());
                }
            }

            // 生成卖出通知
            if (Constants.STOCK_FLAG_DEFAULT == stock.getSellNoticeFlag().intValue() && price >= stock.getMaxPrice().floatValue()) {
                notice.setUserId(stock.getUserId());
                notice.setStockId(stock.getStockId());
                notice.setTitle(Constants.NOTICE_TITLE_SELL);
                notice.setContent(stock.getStockName() + "（" + stock.getStockCode() + "）当前价格为" + price + "，高于或等于您的卖出价格" + stock.getMaxPrice()
                        + "，请及时卖出！");

                if (noticeDao.add(notice)) {
                    sellStockIds.append(",").append(stock.getStockId());
                }
            }
        }

        // 更新SnStock标记
        if (buyStockIds.length() > 1) {
            stockDao.updateBuyFlag(buyStockIds.toString());
        }
        if (sellStockIds.length() > 1) {
            stockDao.updateSellFlag(sellStockIds.toString());
        }
    }
}
