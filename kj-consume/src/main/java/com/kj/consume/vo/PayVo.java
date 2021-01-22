package com.kj.consume.vo;

import java.io.Serializable;

/**
 * @author quan
 * @date 2021-01-20 15:35
 */

public class PayVo implements Serializable {
    private static final long serialVersionUID = -387274279992015670L;
    private Long userId;
    private String orderId;
    private String remarks;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
