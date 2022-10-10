package com.wejuai.entity.mongo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ZM.Wang
 */
public class SystemMessage extends BaseEntity {

    @ApiModelProperty("内容")
    private String text;

    @ApiModelProperty("是否已读")
    private boolean watch;

    private String userId;

    @ApiModelProperty("是否群发")
    private boolean groupPush;

    public SystemMessage(String text, String userId, boolean groupPush) {
        this.text = text;
        this.userId = userId;
        this.watch = false;
        this.groupPush = groupPush;
    }

    SystemMessage() {
    }

    public String getText() {
        return text;
    }

    public boolean getWatch() {
        return watch;
    }

    public String getUserId() {
        return userId;
    }

    public SystemMessage setWatch(boolean watch) {
        this.watch = watch;
        return this;
    }

    public boolean getGroupPush() {
        return groupPush;
    }
}
