package com.wejuai.entity.session;

import com.wejuai.entity.mysql.Sex;

import java.io.Serializable;

/**
 * @author ZM.Wang
 */
public class WeixinUserInfo implements Serializable {

    private String province;
    private String city;
    private String country;
    private Sex sex;
    private String avatar;
    private String nickName;
    private String unionId;
    private String openId;
    private WxLoginType type;

    public WeixinUserInfo(String province, String city, String country, Sex sex, String avatar, String nickName, String unionId, String openId, WxLoginType type) {
        this.province = province;
        this.city = city;
        this.country = country;
        this.sex = sex;
        this.avatar = avatar;
        this.nickName = nickName;
        this.unionId = unionId;
        this.openId = openId;
        this.type = type;
    }

    public WeixinUserInfo(String unionId, String openId, WxLoginType type) {
        this.unionId = unionId;
        this.openId = openId;
        this.type = type;
    }

    WeixinUserInfo() {
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

    public Sex getSex() {
        return sex;
    }

    public String getUnionId() {
        return unionId;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public WxLoginType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "WeixinUserInfo{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", sex=" + sex +
                ", avatar='" + avatar + '\'' +
                ", nickName='" + nickName + '\'' +
                ", unionId='" + unionId + '\'' +
                ", openId='" + openId + '\'' +
                ", type=" + type +
                '}';
    }
}
