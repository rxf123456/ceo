package studio.jikewang.util;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页对应的实体类
 */
public class Page {

    /**
     * 总条数
     */
    @JsonIgnore
    private int totalNumber;

    /**
     * 当前第几页
     */
    private int currentPage;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 每页显示条数
     */
    @JsonIgnore
    private int pageSize = 5;

    /**
     * 数据库中limit的参数，从第几条开始取
     */
    @JsonIgnore
    private int offset;


    @JsonIgnore
    private String order = "ASC";


    @JsonIgnore
    private String orderType = "id";

    private Object object;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;

    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Page{" +
                "totalNumber=" + totalNumber +
                ", currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", order='" + order + '\'' +
                ", orderType='" + orderType + '\'' +
                ", object=" + object +
                '}';
    }
}
