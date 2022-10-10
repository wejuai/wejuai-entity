package com.wejuai.entity.mongo;

import com.wejuai.entity.mysql.App;

/**
 * @author ZM.Wang
 * 回复
 */
public abstract class Reply extends BaseEntity {

    private String sender;      //发送者
    private String appCreator;  //app创建人id
    private AppType appType;
    private String appId;
    private String appTitle;
    private String text;
    boolean watch;      //是否阅读

    Reply(String sender, String appCreator, App<?> app, String text) {
        this.sender = sender;
        this.appCreator = appCreator;
        this.watch = false;
        this.appType = app.getAppType();
        this.appId = app.getId();
        this.appTitle = app.getTitle();
        this.text = text;
    }

    Reply() {
    }

    public abstract <T extends Reply> T watch();

    public String getSender() {
        return sender;
    }

    public String getAppCreator() {
        return appCreator;
    }

    public boolean getWatch() {
        return watch;
    }

    public AppType getAppType() {
        return appType;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppTitle() {
        return appTitle;
    }

    public String getText() {
        return text;
    }
}
