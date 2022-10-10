package com.wejuai.entity.mongo;


/**
 * @author ZM.Wang
 */
public class IntegralRefreshProblem extends BaseEntity {

    private String user;

    private long haveIntegral;

    private long actualIntegral;

    public IntegralRefreshProblem(String user, long haveIntegral, long actualIntegral) {
        this.user = user;
        this.haveIntegral = haveIntegral;
        this.actualIntegral = actualIntegral;
    }

    IntegralRefreshProblem() {
    }

    public String getUser() {
        return user;
    }

    public long getHaveIntegral() {
        return haveIntegral;
    }

    public long getActualIntegral() {
        return actualIntegral;
    }
}
