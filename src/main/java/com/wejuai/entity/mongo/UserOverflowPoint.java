package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 用户溢出的积分
 */
public class UserOverflowPoint extends UserPointRecord {

    public UserOverflowPoint(String user, UserPointType type, long point) {
        super(user, type, point);
    }

    UserOverflowPoint() {
    }
}
