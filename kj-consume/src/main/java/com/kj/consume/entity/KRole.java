package com.kj.consume.entity;

import javax.persistence.*;

@Table(name = "k_role")
public class KRole {
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    private String name;

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
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}