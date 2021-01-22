package com.kj.consume.entity;

import javax.persistence.*;

@Table(name = "k_user_address")
public class KUserAddress {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "address_detail")
    private String addressDetail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_name")
    private String contactName;

    /**
     * 1默认
     */
    @Column(name = "def")
    private Integer def;

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
     * @return address_detail
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * @param addressDetail
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    /**
     * @return contact_phone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    /**
     * @return contact_name
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    /**
     * 获取1默认
     *
     * @return def - 1默认
     */
    public Integer getDef() {
        return def;
    }

    /**
     * 设置1默认
     *
     * @param def 1默认
     */
    public void setDef(Integer def) {
        this.def = def;
    }
}