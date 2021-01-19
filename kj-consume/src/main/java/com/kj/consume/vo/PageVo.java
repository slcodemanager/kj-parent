package com.kj.consume.vo;

import java.io.Serializable;

/**
 * @author quan
 * @date 2021-01-18 13:55
 */

public class PageVo implements Serializable {
    private static final long serialVersionUID = 8395349698004126708L;
    private Long total;
    private Integer per_page;
    private Integer current_page;
    private Integer last_page;
    private Object data;

    public PageVo(Long total, Integer per_page, Integer current_page, Integer last_page, Object data) {
        this.total = total;
        this.per_page = per_page;
        this.current_page = current_page;
        this.last_page = last_page;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public Integer getLast_page() {
        return last_page;
    }

    public void setLast_page(Integer last_page) {
        this.last_page = last_page;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
