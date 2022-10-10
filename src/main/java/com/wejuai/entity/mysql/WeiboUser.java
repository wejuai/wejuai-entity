package com.wejuai.entity.mysql;

import javax.persistence.Entity;

/**
 * @author ZM.Wang
 */
@Entity
public class WeiboUser extends OtherUser {

    private String openId;

    public WeiboUser() {
        super(OauthType.WEIBO);
    }

    public WeiboUser update(String uid, String nickName, String avatar, Sex sex) {
        this.openId = uid;
        super.nickName = nickName;
        super.sex = sex;
        super.avatar = avatar;
        return this;
    }

    public String getOpenId() {
        return openId;
    }
}
