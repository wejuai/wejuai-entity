package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 收藏
 */
public class Collection extends BaseEntity {

    /** 关注者 */
    private String userId;
    private String appId;
    private AppType appType;
    /** 应用创建人 */
    private String createUserId;

    public Collection(String userId, String appId, AppType appType, String createUserId) {
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
