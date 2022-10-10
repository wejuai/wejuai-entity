package com.wejuai.entity.mongo;

import java.time.LocalDate;

/**
 * @author ZM.Wang
 * 用户贡献点记录
 */
public class UserPointRecord extends BaseEntity {

    private String user;

    private UserPointType type;

    private long point;

    private LocalDate date;

    /** 评论积分才有，用于删除评论去除积分 */
    private String commentId;

    public UserPointRecord(String user, UserPointType type, long point) {
        this.user = user;
        this.type = type;
        this.point = point;
        this.date = LocalDate.now();
    }

    public UserPointRecord setCommentId(String commentId) {
        this.commentId = commentId;
        return this;
    }

    UserPointRecord() {
    }

    public String getUser() {
        return user;
    }

    public UserPointType getType() {
        return type;
    }

    public long getPoint() {
        return point;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCommentId() {
        return commentId;
    }
}
