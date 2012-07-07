package sn.core.persistence.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import sn.base.persistence.model.BaseObject;

/**
 * 股票数据模型
 * 
 * @author 王耀
 * 
 */
public class SnStock extends BaseObject {
    private static final long serialVersionUID = -155137833727879645L;

    // Fields

    private Integer stockId;
    private Integer userId;
    private String stockName;
    private String stockCode;
    private Float minPrice;
    private Float maxPrice;
    private Short buyNoticeFlag;
    private Short sellNoticeFlag;

    // Constructors

    /** default constructor */
    public SnStock() {
    }

    /** minimal constructor */
    public SnStock(Integer stockId, Integer userId, String stockCode, Short buyNoticeFlag, Short sellNoticeFlag) {
        this.stockId = stockId;
        this.userId = userId;
        this.stockCode = stockCode;
        this.buyNoticeFlag = buyNoticeFlag;
        this.sellNoticeFlag = sellNoticeFlag;
    }

    /** full constructor */
    public SnStock(Integer stockId, Integer userId, String stockName, String stockCode, Float minPrice, Float maxPrice, Short buyNoticeFlag,
            Short sellNoticeFlag) {
        this.stockId = stockId;
        this.userId = userId;
        this.stockName = stockName;
        this.stockCode = stockCode;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.buyNoticeFlag = buyNoticeFlag;
        this.sellNoticeFlag = sellNoticeFlag;
    }

    // Property accessors

    public Integer getStockId() {
        return this.stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStockName() {
        return this.stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return this.stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public Float getMinPrice() {
        return this.minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return this.maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Short getBuyNoticeFlag() {
        return this.buyNoticeFlag;
    }

    public void setBuyNoticeFlag(Short buyNoticeFlag) {
        this.buyNoticeFlag = buyNoticeFlag;
    }

    public Short getSellNoticeFlag() {
        return this.sellNoticeFlag;
    }

    public void setSellNoticeFlag(Short sellNoticeFlag) {
        this.sellNoticeFlag = sellNoticeFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SnStock))
            return false;

        if (this == o)
            return true;

        SnStock other = (SnStock) o;
        return new EqualsBuilder().append(this.getStockId(), other.getStockId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getStockId()).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("stockId", getStockId()).append("userId", getUserId()).append("stockName", getStockName())
                .append("stockCode", getStockCode()).append("minPrice", getMinPrice()).append("maxPrice", getMaxPrice()).append(
                        "buyNoticeFlag", getBuyNoticeFlag()).append("sellNoticeFlag", getSellNoticeFlag()).toString();
    }

}