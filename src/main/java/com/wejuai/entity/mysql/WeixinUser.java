package com.wejuai.entity.mysql;

import javax.persistence.Entity;

/**
 * @author ZM.Wang
 */
@Entity
public class WeixinUser extends OtherUser {

    /** 公众号openId */
    private String offiOpenId;
    /** 开放平台openId */
    private String openId;
    /** 小程序openId */
    private String appOpenId;
    private String province;
    private String city;
    private String country;
    private String unionId;

    public WeixinUser() {
        super(OauthType.WEIXIN);
    }

    public WeixinUser update(String province, String city, String country, Sex sex, String nickName, String avatar, String unionId) {
        this.update(province, city, country, sex, nickName, avatar);
        this.unionId = unionId;
        return this;
    }

    public WeixinUser update(String province, String city, String country, Sex sex, String nickName, String avatar) {
        super.nickName = nickName;
        super.sex = sex;
        super.avatar = avatar;
        this.province = province;
        this.city = city;
        this.country = country;
        return this;
    }

    public WeixinUser update(String appOpenId, String unionId) {
        this.appOpenId = appOpenId;
        this.unionId = unionId;
        return this;
    }

    public WeixinUser setOffiOpenId(String offiOpenId) {
        this.offiOpenId = offiOpenId;
        return this;
    }

    public WeixinUser setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getOffiOpenId() {
        return offiOpenId;
    }

    public String getOpenId() {
        return openId;
    }

    public String getAppOpenId() {
        return appOpenId;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getUnionId() {
        return unionId;
    }
}
