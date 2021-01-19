package com.kj.consume.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "k_product")
public class KProduct implements Serializable {
    private static final long serialVersionUID = 6876438235861087165L;
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "name")
    private String name;

    /**
     * 简介
     */
    @Column(name = "brief")
    private String brief;

    /**
     * 原价
     */
    @Column(name = "market_price")
    private BigDecimal marketPrice;

    /**
     * 售卖价格
     */
    @Column(name = "shop_price")
    private BigDecimal shopPrice;

    /**
     * 商品折扣
     */
    @Column(name = "rebate")
    private BigDecimal rebate;

    /**
     * 原材料价格
     */
    @Column(name = "materials_price")
    private BigDecimal materialsPrice;

    /**
     * 主图
     */
    @Column(name = "img")
    private String img;

    /**
     * 排序优先级 大-小
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 点击总量
     */
    @Column(name = "click_count")
    private Long clickCount;

    /**
     * 销售总量
     */
    @Column(name = "sales_sum")
    private Long salesSum;

    /**
     * 库存
     */
    @Column(name = "number")
    private Long number;

    /**
     * 是否免费邮寄
     */
    @Column(name = "is_free_shipping")
    private Integer isFreeShipping;

    /**
     * 商品类型
     */
    @Column(name = "goods_type")
    private Integer goodsType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return category_id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return category_name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取简介
     *
     * @return brief - 简介
     */
    public String getBrief() {
        return brief;
    }

    /**
     * 设置简介
     *
     * @param brief 简介
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * 获取原价
     *
     * @return market_price - 原价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 设置原价
     *
     * @param marketPrice 原价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 获取售卖价格
     *
     * @return shop_price - 售卖价格
     */
    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    /**
     * 设置售卖价格
     *
     * @param shopPrice 售卖价格
     */
    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * 获取商品折扣
     *
     * @return rebate - 商品折扣
     */
    public BigDecimal getRebate() {
        return rebate;
    }

    /**
     * 设置商品折扣
     *
     * @param rebate 商品折扣
     */
    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    /**
     * 获取原材料价格
     *
     * @return materials_price - 原材料价格
     */
    public BigDecimal getMaterialsPrice() {
        return materialsPrice;
    }

    /**
     * 设置原材料价格
     *
     * @param materialsPrice 原材料价格
     */
    public void setMaterialsPrice(BigDecimal materialsPrice) {
        this.materialsPrice = materialsPrice;
    }

    /**
     * 获取主图
     *
     * @return img - 主图
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置主图
     *
     * @param img 主图
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取排序优先级 大-小
     *
     * @return order_num - 排序优先级 大-小
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排序优先级 大-小
     *
     * @param orderNum 排序优先级 大-小
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取点击总量
     *
     * @return click_count - 点击总量
     */
    public Long getClickCount() {
        return clickCount;
    }

    /**
     * 设置点击总量
     *
     * @param clickCount 点击总量
     */
    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 获取销售总量
     *
     * @return sales_sum - 销售总量
     */
    public Long getSalesSum() {
        return salesSum;
    }

    /**
     * 设置销售总量
     *
     * @param salesSum 销售总量
     */
    public void setSalesSum(Long salesSum) {
        this.salesSum = salesSum;
    }

    /**
     * 获取库存
     *
     * @return number - 库存
     */
    public Long getNumber() {
        return number;
    }

    /**
     * 设置库存
     *
     * @param number 库存
     */
    public void setNumber(Long number) {
        this.number = number;
    }

    /**
     * 获取是否免费邮寄
     *
     * @return is_free_shipping - 是否免费邮寄
     */
    public Integer getIsFreeShipping() {
        return isFreeShipping;
    }

    /**
     * 设置是否免费邮寄
     *
     * @param isFreeShipping 是否免费邮寄
     */
    public void setIsFreeShipping(Integer isFreeShipping) {
        this.isFreeShipping = isFreeShipping;
    }

    /**
     * 获取商品类型
     *
     * @return goods_type - 商品类型
     */
    public Integer getGoodsType() {
        return goodsType;
    }

    /**
     * 设置商品类型
     *
     * @param goodsType 商品类型
     */
    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}