package sn.base.persistence;

import java.io.Serializable;

/**
 * 分页信息类
 * 
 * @author 王耀
 * 
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 1673449962077954004L;

    private int pageNo = 1; // 当前页号

    private int pageSize = 10; // 每页记录数

    private long totalRows = 0; // 总记录数

    private long totalPages = 0; // 总页数

    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页号
     * 
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页记录数
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }

    public long getTotalRows() {
        return totalRows;
    }

    /**
     * 设置总记录数
     * 
     * @param totalRows
     */
    public void setTotalRows(long totalRows) {
        if (totalRows > 0) {
            this.totalRows = totalRows;
        }

        // 计算总页数
        totalPages = (this.totalRows + pageSize - 1) / pageSize;

        // 重置当前页号
        if (pageNo > totalPages) {
            pageNo = 1;
        }
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public String toString() {
        return "[pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalRows=" + totalRows + ", totalPages=" + totalPages + "]";
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pageNo;
        result = prime * result + pageSize;
        result = prime * result + (int) (totalPages ^ (totalPages >>> 32));
        result = prime * result + (int) (totalRows ^ (totalRows >>> 32));
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Page other = (Page) obj;
        if (pageNo != other.pageNo)
            return false;
        if (pageSize != other.pageSize)
            return false;
        if (totalPages != other.totalPages)
            return false;
        if (totalRows != other.totalRows)
            return false;
        return true;
    }
}
