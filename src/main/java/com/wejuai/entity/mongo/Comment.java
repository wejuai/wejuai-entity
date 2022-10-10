package com.wejuai.entity.mongo;

import com.wejuai.entity.mysql.App;

/**
 * @author ZM.Wang
 * 一级级评论
 */
public class Comment extends Reply {

    private long starNum;//点赞数
    private long subCommentNum; //子回复数量
    private boolean authorCommented; //作者是否评论

    public Comment(String sender, String receiver, App<?> app, String text) {
        super(sender, receiver, app, text);
        this.starNum = 0;
        this.subCommentNum = 0;
    }

    public Comment setStarNum(long starNum) {
        this.starNum = starNum;
        return this;
    }

    public Comment setSubCommentNum(long subCommentNum) {
        this.subCommentNum = subCommentNum;
        return this;
    }

    public boolean getAuthorCommented() {
        return authorCommented;
    }

    public Comment setAuthorCommented(boolean authorCommented) {
        this.authorCommented = authorCommented;
        return this;
    }

    Comment() {
    }

    public long getStarNum() {
        return starNum;
    }

    public long getSubCommentNum() {
        return subCommentNum;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Comment watch() {
        super.watch = true;
        return this;
    }
}
