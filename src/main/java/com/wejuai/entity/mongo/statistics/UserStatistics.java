package com.wejuai.entity.mongo.statistics;

/**
 * @author ZM.Wang
 */
public class UserStatistics {

    private String id;

    private long userRegister;

    private long imMsg;

    public UserStatistics(String id) {
        this.id = id;
        this.userRegister = 0;
        this.imMsg = 0;
    }

    public UserStatistics addUserRegister(long userRegister) {
        this.userRegister = +userRegister;
        return this;
    }

    public UserStatistics addImMsg(long imMsg) {
        this.imMsg += imMsg;
        return this;
    }

    UserStatistics() {
    }

    public String getId() {
        return id;
    }

    public long getUserRegister() {
        return userRegister;
    }

    public long getImMsg() {
        return imMsg;
    }
}
