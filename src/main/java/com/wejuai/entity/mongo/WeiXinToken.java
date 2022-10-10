package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class WeiXinToken {

    /** appId */
    private String id;
    private String token;
    private long expiredAt;

    public WeiXinToken(String id) {
        this.id = id;
    }

    public WeiXinToken update(String token, long expiredAt) {
        this.token = token;
        this.expiredAt = expiredAt;
        return this;
    }

    WeiXinToken() {
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public long getExpiredAt() {
        return expiredAt;
    }
}
