package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class PointRefreshProblem extends BaseEntity {

    private String user;

    /** 拥有的点数 */
    private long havePoint;

    /** 实际的点数 */
    private long actualPoint;

    public PointRefreshProblem(String user, long havePoint, long actualPoint) {
        this.user = user;
        this.havePoint = havePoint;
        this.actualPoint = actualPoint;
    }

    PointRefreshProblem() {
    }

    public String getUser() {
        return user;
    }

    public long getHavePoint() {
        return havePoint;
    }

    public long getActualPoint() {
        return actualPoint;
    }
}
