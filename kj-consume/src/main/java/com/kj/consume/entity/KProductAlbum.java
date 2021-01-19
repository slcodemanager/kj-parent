package com.kj.consume.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "k_product_album")
public class KProductAlbum {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "url")
    private String url;

    /**
     * 1展示 2 详情
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 降序排序
     */
    @Column(name = "order_num")
    private Integer orderNum;

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
     * @return product_id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取1展示 2 详情
     *
     * @return type - 1展示 2 详情
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1展示 2 详情
     *
     * @param type 1展示 2 详情
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取降序排序
     *
     * @return order_num - 降序排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置降序排序
     *
     * @param orderNum 降序排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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