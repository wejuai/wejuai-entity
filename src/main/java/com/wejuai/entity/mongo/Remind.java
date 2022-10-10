package com.wejuai.entity.mongo;

import com.wejuai.entity.mysql.App;

/**
 * @author ZM.Wang
 * 艾特的通知
 */
public class Remind extends Reply {

    private String recipient;   //接收者

    private String commentId;

    public Remind(String sender, String appCreator, String recipient, App app, String text, String commentId) {
        super(sender, appCreator, app, text);
        this.recipient = recipient;
        this.commentId = commentId;
    }

    Remind() {
    }

    public String getRecipient() {
        return recipient;
    }

    public String getCommentId() {
        return commentId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Remind watch() {
        super.watch = true;
        return this;
    }
}
