package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 子评论点赞
 */
public class SubCommentStar extends BaseEntity {

    private String userId;
    private String subCommentId;

    public SubCommentStar(String userId, String subCommentId) {
        this.userId = userId;
        this.subCommentId = subCommentId;
    }

    SubCommentStar() {
    }

    public String getUserId() {
        return userId;
    }

    public String getSubCommentId() {
        return subCommentId;
    }
}
