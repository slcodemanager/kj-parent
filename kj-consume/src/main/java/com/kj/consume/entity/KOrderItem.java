package com.kj.consume.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "k_order_item")
public class KOrderItem {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "p_id")
    private Long pId;

    @Column(name = "p_price")
    private BigDecimal pPrice;

    @Column(name = "p_name")
    private String pName;

    @Column(name = "p_amount")
    private Integer pAmount;

    @Column(name = "p_img")
    private String pImg;

    @Column(name = "spec_id")
    private Long specId;

    @Column(name = "spec_tips")
    private String specTips;

    @Column(name = "add_time")
    private Date addTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return order_id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * @return p_id
     */
    public Long getpId() {
        return pId;
    }

    /**
     * @param pId
     */
    public void setpId(Long pId) {
        this.pId = pId;
    }

    /**
     * @return p_price
     */
    public BigDecimal getpPrice() {
        return pPrice;
    }

    /**
     * @param pPrice
     */
    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    /**
     * @return p_name
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * @return p_amount
     */
    public Integer getpAmount() {
        return pAmount;
    }

    /**
     * @param pAmount
     */
    public void setpAmount(Integer pAmount) {
        this.pAmount = pAmount;
    }

    /**
     * @return p_img
     */
    public String getpImg() {
        return pImg;
    }

    /**
     * @param pImg
     */
    public void setpImg(String pImg) {
        this.pImg = pImg == null ? null : pImg.trim();
    }

    /**
     * @return spec_id
     */
    public Long getSpecId() {
        return specId;
    }

    /**
     * @param specId
     */
    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    /**
     * @return spec_tips
     */
    public String getSpecTips() {
        return specTips;
    }

    /**
     * @param specTips
     */
    public void setSpecTips(String specTips) {
        this.specTips = specTips == null ? null : specTips.trim();
    }

    /**
     * @return add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}