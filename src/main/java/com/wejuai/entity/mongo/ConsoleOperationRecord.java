package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 管理后台操作记录
 */
public class ConsoleOperationRecord extends BaseEntity {

    /** 操作 */
    private String operation;

    private String ip;

    private String sessionId;

    private String method;

    private String content;

    public ConsoleOperationRecord(String operation, String ip, String sessionId, String method, String content) {
        this.operation = operation;
        this.ip = ip;
        this.sessionId = sessionId;
        this.method = method;
        this.content = content;
    }

    ConsoleOperationRecord() {
    }

    public String getOperation() {
        return operation;
    }

    public String getIp() {
        return ip;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getMethod() {
        return method;
    }

    public String getContent() {
        return content;
    }
}
