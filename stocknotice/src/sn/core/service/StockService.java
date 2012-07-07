package sn.core.service;

/**
 * 股价服务
 * 
 * @author 王耀
 * 
 */
public interface StockService {

    /**
     * 实时获取股票价格
     * 
     * @param stockCodeArray 股票代码数组
     * @return
     */
    public float[] price(String[] stockCodeArray);

    /**
     * 实时获取股票价格
     * 
     * @param stockCode 股票代码
     * @return
     */
    public float price(String stockCode);

}
