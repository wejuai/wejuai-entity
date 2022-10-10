package com.wejuai.entity.session;

import com.wejuai.entity.mysql.OauthType;

import java.io.Serializable;

/**
 * @author YQ.Huang
 */
public class BindRequest implements Serializable {

    private OauthType oauthType;
    private String accessToken;
    /** 各家用户id */
    private String openId;
    private WeixinUserInfo weixinUserInfo;

    public static BindRequest qq(String accessToken, String userId) {
        BindRequest bind = new BindRequest();
        bind.oauthType = OauthType.QQ;
        bind.accessToken = accessToken;
        bind.openId = userId;
        return bind;
    }

    public static BindRequest weibo(String accessToken, String userId) {
        BindRequest bind = new BindRequest();
        bind.oauthType = OauthType.WEIBO;
        bind.accessToken = accessToken;
        bind.openId = userId;
        return bind;
    }

    public static BindRequest weixin(WeixinUserInfo weixinUserInfo) {
        BindRequest bind = new BindRequest();
        bind.oauthType = OauthType.WEIXIN;
        bind.weixinUserInfo = weixinUserInfo;
        return bind;
    }

    public OauthType getOauthType() {
        return oauthType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getOpenId() {
        return openId;
    }

    public WeixinUserInfo getWeixinUserInfo() {
        return weixinUserInfo;
    }

    @Override
    public String toString() {
        return "BindRequest{" +
                "oauthType=" + oauthType +
                ", accessToken='" + accessToken + '\'' +
                ", openId='" + openId + '\'' +
                ", weixinUserInfo=" + weixinUserInfo +
                '}';
    }
}
