package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 点赞
 */
public class Star extends BaseEntity {

    private String userId;
    private String appId;
    private AppType appType;
    private String createUserId;

    public Star(String userId, String appId, AppType appType, String createUserId) {
        this.userId = userId;
        this.appId = appId;
        this.appType = appType;
        this.createUserId = createUserId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAppId() {
        return appId;
    }

    public AppType getAppType() {
        return appType;
    }

    public String getCreateUserId() {
        return createUserId;
    }
}
