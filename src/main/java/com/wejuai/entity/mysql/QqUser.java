package com.wejuai.entity.mysql;

import javax.persistence.Entity;

/**
 * @author ZM.Wang
 */
@Entity
public class QqUser extends OtherUser {

    private String openId;

    public QqUser() {
        super(OauthType.QQ);
    }

    public QqUser update(String openId, String nickName, String avatar, Sex sex) {
        this.openId = openId;
        super.nickName = nickName;
        super.avatar = avatar;
        super.sex = sex;
        return this;
    }

    public String getOpenId() {
        return openId;
    }
}
