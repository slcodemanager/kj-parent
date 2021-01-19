package com.kj.consume.vo;

import java.io.Serializable;

/**
 * @author quan
 * @date 2021-01-18 12:31
 */

public class ProductSearchParams implements Serializable {
    private static final long serialVersionUID = 2732116958157717312L;
    private String queryString;
    private Integer page = 1;
    private Integer perPage = 10;
    private String categoryId;
    private String type = "1";

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
