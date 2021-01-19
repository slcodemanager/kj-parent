package com.kj.consume.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "k_user")
public class KUser {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 用户姓名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 头像
     */
    @Column(name = "img")
    private String img;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "updat_time")
    private Date updatTime;

    /**
     * 消费金额
     */
    @Column(name = "consume_money")
    private BigDecimal consumeMoney;

    /**
     * 微信openid
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 版本
     */
    @Column(name = "version")
    private Long version;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户姓名
     *
     * @return username - 用户姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取头像
     *
     * @return img - 头像
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置头像
     *
     * @param img 头像
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return updat_time - 更新时间
     */
    public Date getUpdatTime() {
        return updatTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatTime 更新时间
     */
    public void setUpdatTime(Date updatTime) {
        this.updatTime = updatTime;
    }

    /**
     * 获取消费金额
     *
     * @return consume_money - 消费金额
     */
    public BigDecimal getConsumeMoney() {
        return consumeMoney;
    }

    /**
     * 设置消费金额
     *
     * @param consumeMoney 消费金额
     */
    public void setConsumeMoney(BigDecimal consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    /**
     * 获取微信openid
     *
     * @return open_id - 微信openid
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置微信openid
     *
     * @param openId 微信openid
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 获取版本
     *
     * @return version - 版本
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}