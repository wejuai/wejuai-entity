package com.wejuai.entity.mongo;

import com.wejuai.entity.mysql.App;

import static com.wejuai.entity.mongo.ReportType.APP;
import static com.wejuai.entity.mongo.ReportType.USER;

/**
 * @author ZM.Wang
 * 举报
 */
public class Report extends BaseEntity {

    private ReportType type;

    private String userId;

    /** 被举报人 */
    private String beUserId;

    private String appId;

    private String appType;

    private String reason;

    public Report(String userId, App<?> app, String reason) {
        this.userId = userId;
        this.reason = reason;
        this.type = APP;
        if (app != null) {
            this.appId = app.getId();
            this.appType = app.getAppType().toString();
        }
    }

    public Report(String userId, String appId, String appType, String reason) {
        this.type = APP;
        this.userId = userId;
        this.appId = appId;
        this.appType = appType;
        this.reason = reason;
    }

    public Report(String userId, String beUserId, String reason) {
        this.type = USER;
        this.userId = userId;
        this.beUserId = beUserId;
        this.reason = reason;
    }

    Report() {
    }

    public String getUserId() {
        return userId;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppType() {
        return appType;
    }

    public String getReason() {
        return reason;
    }

    public String getBeUserId() {
        return beUserId;
    }

    public ReportType getType() {
        return type;
    }
}
