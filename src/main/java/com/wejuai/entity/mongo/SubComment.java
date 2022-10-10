package com.wejuai.entity.mongo;

import com.wejuai.entity.mysql.App;

/**
 * @author ZM.Wang
 * 二级评论
 */
public class SubComment extends Reply {

    private String recipient;   //接收者
    private long starNum;       //点赞数
    private String commentId;   //一级评论id

    public SubComment(String sender, String appCreator, String recipient, App<?> app, String text, Comment comment) {
        super(sender, appCreator, app, text);
        this.recipient = recipient;
        this.commentId = comment.getId();
        this.starNum = 0;
    }

    public SubComment setStarNum(long starNum) {
        this.starNum = starNum;
        return this;
    }

    SubComment() {
    }

    public String getRecipient() {
        return recipient;
    }

    public long getStarNum() {
        return starNum;
    }

    public String getCommentId() {
        return commentId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SubComment watch() {
        super.watch = true;
        return this;
    }
}
