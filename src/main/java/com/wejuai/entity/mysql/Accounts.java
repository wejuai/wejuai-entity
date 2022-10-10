package com.wejuai.entity.mysql;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZM.Wang
 */
@Entity
public class Accounts extends BaseEntity {
    private String phone;
    private String email;
    private String password;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private QqUser qqUser;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private WeiboUser weiboUser;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private WeixinUser weixinUser;
    /** 当前ip */
    private String ip;

    public Accounts cancelAccount() {
        this.phone = null;
        this.email = null;
        this.password = null;
        this.qqUser = null;
        this.weiboUser = null;
        this.weixinUser = null;
        this.ip = null;
        return this;
    }

    public Accounts(String id, String email, String password) {
        this(email, password);
        super.id = id;
    }

    @SuppressWarnings("WeakerAccess")
    public Accounts(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * @param weixinUser 微信用户, 只有小程序注册才能调用
     */
    public Accounts(WeixinUser weixinUser) {
        this.weixinUser = weixinUser;
    }

    public boolean login(String password) {
        return StringUtils.equals(this.password, password);
    }

    public String getIp() {
        return ip;
    }

    public Accounts setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Accounts setQqUser(QqUser qqUser) {
        this.qqUser = qqUser;
        return this;
    }

    public Accounts setWeiboUser(WeiboUser weiboUser) {
        this.weiboUser = weiboUser;
        return this;
    }

    public WeiboUser getWeiboUser() {
        return weiboUser;
    }

    public WeixinUser getWeixinUser() {
        return weixinUser;
    }

    public Accounts setWeixinUser(WeixinUser weixinUser) {
        this.weixinUser = weixinUser;
        return this;
    }

    public Accounts setPassword(String password) {
        this.password = password;
        return this;
    }

    public Accounts(String id) {
        this.id = id;
    }

    public Accounts setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<OtherUser> getOtherUsers() {
        List<OtherUser> otherUsers = new ArrayList<>();
        otherUsers.add(qqUser);
        otherUsers.add(weiboUser);
        otherUsers.add(weixinUser);
        return otherUsers;
    }

    public Accounts setEmail(String email) {
        this.email = email;
        return this;
    }

    Accounts() {
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public QqUser getQqUser() {
        return qqUser;
    }
}
