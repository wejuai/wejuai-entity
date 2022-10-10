package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 评论点赞
 */
public class CommentStar extends BaseEntity {

    private String userId;
    private String commentId;

    public CommentStar(String userId, String commentId) {
        this.userId = userId;
        this.commentId = commentId;
    }

    CommentStar() {
    }

    public String getUserId() {
        return userId;
    }

    public String getCommentId() {
        return commentId;
    }
}
