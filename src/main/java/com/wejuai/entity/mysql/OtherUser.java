package com.wejuai.entity.mysql;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

/**
 * @author ZM.Wang
 */
@MappedSuperclass
public class OtherUser extends BaseEntity {

    String nickName;
    String avatar;
    @Enumerated(EnumType.STRING)
    Sex sex;
    @Enumerated(EnumType.STRING)
    private OauthType oauthType;

    OtherUser(OauthType oauthType) {
        this.oauthType = oauthType;
    }

    OtherUser() {
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public Sex getSex() {
        return sex;
    }

    public OauthType getOauthType() {
        return oauthType;
    }
}
