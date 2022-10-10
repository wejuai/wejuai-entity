package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author ZM.Wang
 * 用户收货地址
 */
@Entity
public class Address extends BaseEntity {

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;
    private String phone;
    private String province;
    private String city;
    private String region;

    /** 详细地址 */
    private String detailed;

    public Address(User user) {
        this.user = user;
    }

    public Address update(String phone, String province, String city, String region, String detailed) {
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.region = region;
        this.detailed = detailed;
        return this;
    }

    Address() {
    }

    public User getUser() {
        return user;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getDetailed() {
        return detailed;
    }
}
