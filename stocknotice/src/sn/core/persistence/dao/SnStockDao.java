package sn.core.persistence.dao;

import java.util.List;

import sn.base.persistence.dao.Dao;
import sn.core.persistence.model.SnStock;

/**
 * 股票数据接口
 * 
 * @author 王耀
 * 
 */
public interface SnStockDao extends Dao {

    /**
     * 获取未生成通知的股票
     * 
     * @return
     */
    public List<SnStock> getUnNoticeStock();

    /**
     * 获取需要更新价格的股票代码
     * 
     * @return
     */
    public String[] getStockCode();

    /**
     * 更新买入通知标记
     * 
     * @param stockIds
     * @return
     */
    public boolean updateBuyFlag(String stockIds);

    /**
     * 更新卖出通知标记
     * 
     * @param stockIds
     * @return
     */
    public boolean updateSellFlag(String stockIds);

    /**
     * 重置所有股票通知标记
     * 
     * @return
     */
    public boolean resetAllFlag();

}
