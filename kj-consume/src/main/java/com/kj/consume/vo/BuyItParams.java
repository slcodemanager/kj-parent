package com.kj.consume.vo;

import java.io.Serializable;

/**
 * @author quan
 * @date 2021-01-18 17:26
 */

public class BuyItParams implements Serializable {
    private static final long serialVersionUID = 2373050763099944044L;
    private Long userId;
    private Long productId;
    private Integer amount;
    private Long specId;

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
