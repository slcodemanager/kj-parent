package com.kj.consume.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "k_product_spec")
public class KProductSpec {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    /**
     * 0规格名称 其他 规格属性
     */
    @Column(name = "parent")
    private Long parent;

    /**
     * 暂不使用
     */
    @Column(name = "img")
    private String img;



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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取0规格名称 其他 规格属性
     *
     * @return parent - 0规格名称 其他 规格属性
     */
    public Long getParent() {
        return parent;
    }

    /**
     * 设置0规格名称 其他 规格属性
     *
     * @param parent 0规格名称 其他 规格属性
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    /**
     * 获取暂不使用
     *
     * @return img - 暂不使用
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置暂不使用
     *
     * @param img 暂不使用
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}