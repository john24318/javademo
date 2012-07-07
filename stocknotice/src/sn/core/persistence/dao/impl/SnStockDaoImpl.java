package sn.core.persistence.dao.impl;

import java.util.List;

import sn.base.persistence.dao.BaseDao;
import sn.base.util.Constants;
import sn.core.persistence.dao.SnStockDao;
import sn.core.persistence.model.SnStock;

@SuppressWarnings("unchecked")
public class SnStockDaoImpl extends BaseDao implements SnStockDao {

    /**
     * 获取未生成通知的股票
     * 
     * @return
     */
    public List<SnStock> getUnNoticeStock() {
        List<SnStock> list = null;
        String sql = "SELECT stock_id AS stockId, user_id AS userId, stock_name AS stockName, stock_code AS stockCode, min_price AS minPrice, max_price AS maxPrice, buy_notice_flag AS buyNoticeFlag, sell_notice_flag AS sellNoticeFlag FROM sn_stock WHERE buy_notice_flag=? OR sell_notice_flag=?";
        list = find(sql, new Object[] { Constants.STOCK_FLAG_DEFAULT, Constants.STOCK_FLAG_DEFAULT }, SnStock.class);
        return list;
    }

    /**
     * 获取需要更新价格的股票代码
     * 
     * @return
     */
    public String[] getStockCode() {
        String[] ret = null;
        String sql = "SELECT DISTINCT stock_code AS stockCode FROM sn_stock WHERE buy_notice_flag=? OR sell_notice_flag=?";
        List stockCodeList = getOneColumn(sql, new Object[] { Constants.STOCK_FLAG_DEFAULT, Constants.STOCK_FLAG_DEFAULT });
        ret = (String[]) stockCodeList.toArray(new String[] {});
        return ret;
    }

    /**
     * 更新买入通知标记
     */
    public boolean updateBuyFlag(String stockIds) {
        boolean ret = false;
        String sql = "UPDATE sn_stock SET buy_notice_flag=? WHERE stock_id IN (" + stockIds + ")";
        int rows = update(sql, new Object[] { Constants.STOCK_FLAG_NOTICED });
        if (rows > 0) {
            ret = true;
        }

        return ret;
    }

    /**
     * 更新卖出通知标记
     */
    public boolean updateSellFlag(String stockIds) {
        boolean ret = false;
        String sql = "UPDATE sn_stock SET sell_notice_flag=? WHERE stock_id IN (" + stockIds + ")";
        int rows = update(sql, new Object[] { Constants.STOCK_FLAG_NOTICED });
        if (rows > 0) {
            ret = true;
        }

        return ret;
    }

    /**
     * 重置所有股票通知标记
     */
    public boolean resetAllFlag() {
        boolean ret = false;
        String sql = "UPDATE sn_stock SET buy_notice_flag=?, sell_notice_flag=?";
        int rows = update(sql, new Object[] { Constants.STOCK_FLAG_NOTICED, Constants.STOCK_FLAG_NOTICED });
        if (rows > 0) {
            ret = true;
        }

        return ret;
    }
}
