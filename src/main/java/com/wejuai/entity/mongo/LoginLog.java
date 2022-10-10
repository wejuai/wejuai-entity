package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 登录记录
 */
public class LoginLog extends BaseEntity {
    private String accountsId;
    private String ip;

    public LoginLog(String accountsId, String ip) {
        this.accountsId = accountsId;
        this.ip = ip;
    }

    LoginLog() {
    }

    public String getAccountsId() {
        return accountsId;
    }

    public String getIp() {
        return ip;
    }
}
