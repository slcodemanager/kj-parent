package com.kj.consume.entity;

import javax.persistence.*;

@Table(name = "k_product_category")
public class KProductCategory {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * 一级分类 0代表顶级
     */
    @Column(name = "parent")
    private Long parent;

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
     * 获取一级分类 0代表顶级
     *
     * @return parent - 一级分类 0代表顶级
     */
    public Long getParent() {
        return parent;
    }

    /**
     * 设置一级分类 0代表顶级
     *
     * @param parent 一级分类 0代表顶级
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }
}