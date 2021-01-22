package com.kj.consume.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "k_order")
public class KOrder {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "coupon_type")
    private Integer couponType;

    @Column(name = "coupon_price")
    private BigDecimal couponPrice;

    @Column(name = "pay_money")
    private BigDecimal payMoney;

    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 1微信支付 2农行
     */
    @Column(name = "pay_method")
    private Integer payMethod;

    @Column(name = "deduct_price")
    private BigDecimal deductPrice;

    /**
     * 用户收货地址
     */
    @Column(name = "address_id")
    private Long addressId;

    /**
     * 1 顺丰
     */
    @Column(name = "express_type")
    private Integer expressType;

    /**
     * 快递单号
     */
    @Column(name = "express_num")
    private String expressNum;

    @Column(name = "express_price")
    private BigDecimal expressPrice;

    /**
     * 1邮寄中 2快递完成(订单弄成)
     */
    @Column(name = "express_status")
    private Integer expressStatus;

    /**
     * -1失效 0未支付 1已支付
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 0未退款 1退款中 2退款完成
     */
    @Column(name = "return_status")
    private Integer returnStatus;

    @Column(name = "return_price")
    private BigDecimal returnPrice;

    @Column(name = "pre_pay_id")
    private String prePayId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "end_time")
    private Date endTime;

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
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return amount
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * @return coupon_type
     */
    public Integer getCouponType() {
        return couponType;
    }

    /**
     * @param couponType
     */
    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    /**
     * @return coupon_price
     */
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    /**
     * @param couponPrice
     */
    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * @return pay_money
     */
    public BigDecimal getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney
     */
    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * @return pay_time
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取1微信支付 2农行
     *
     * @return pay_method - 1微信支付 2农行
     */
    public Integer getPayMethod() {
        return payMethod;
    }

    /**
     * 设置1微信支付 2农行
     *
     * @param payMethod 1微信支付 2农行
     */
    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * @return deduct_price
     */
    public BigDecimal getDeductPrice() {
        return deductPrice;
    }

    /**
     * @param deductPrice
     */
    public void setDeductPrice(BigDecimal deductPrice) {
        this.deductPrice = deductPrice;
    }

    /**
     * 获取用户收货地址
     *
     * @return address_id - 用户收货地址
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * 设置用户收货地址
     *
     * @param addressId 用户收货地址
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取1 顺丰
     *
     * @return express_type - 1 顺丰
     */
    public Integer getExpressType() {
        return expressType;
    }

    /**
     * 设置1 顺丰
     *
     * @param expressType 1 顺丰
     */
    public void setExpressType(Integer expressType) {
        this.expressType = expressType;
    }

    /**
     * 获取快递单号
     *
     * @return express_num - 快递单号
     */
    public String getExpressNum() {
        return expressNum;
    }

    /**
     * 设置快递单号
     *
     * @param expressNum 快递单号
     */
    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum == null ? null : expressNum.trim();
    }

    /**
     * @return express_price
     */
    public BigDecimal getExpressPrice() {
        return expressPrice;
    }

    /**
     * @param expressPrice
     */
    public void setExpressPrice(BigDecimal expressPrice) {
        this.expressPrice = expressPrice;
    }

    /**
     * 获取1邮寄中 2快递完成(订单弄成)
     *
     * @return express_status - 1邮寄中 2快递完成(订单弄成)
     */
    public Integer getExpressStatus() {
        return expressStatus;
    }

    /**
     * 设置1邮寄中 2快递完成(订单弄成)
     *
     * @param expressStatus 1邮寄中 2快递完成(订单弄成)
     */
    public void setExpressStatus(Integer expressStatus) {
        this.expressStatus = expressStatus;
    }

    /**
     * 获取-1失效 0未支付 1已支付
     *
     * @return status - -1失效 0未支付 1已支付
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置-1失效 0未支付 1已支付
     *
     * @param status -1失效 0未支付 1已支付
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取0未退款 1退款中 2退款完成
     *
     * @return return_status - 0未退款 1退款中 2退款完成
     */
    public Integer getReturnStatus() {
        return returnStatus;
    }

    /**
     * 设置0未退款 1退款中 2退款完成
     *
     * @param returnStatus 0未退款 1退款中 2退款完成
     */
    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    /**
     * @return return_price
     */
    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    /**
     * @param returnPrice
     */
    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    /**
     * @return pre_pay_id
     */
    public String getPrePayId() {
        return prePayId;
    }

    /**
     * @param prePayId
     */
    public void setPrePayId(String prePayId) {
        this.prePayId = prePayId == null ? null : prePayId.trim();
    }

    /**
     * @return transaction_id
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
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

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}