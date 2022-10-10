package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class ConsoleLoginLog extends BaseEntity {

    private String ip;

    private String sessionId;

    public ConsoleLoginLog(String ip, String sessionId) {
        this.ip = ip;
        this.sessionId = sessionId;
    }

    ConsoleLoginLog() {
    }

    public String getIp() {
        return ip;
    }

    public String getSessionId() {
        return sessionId;
    }
}
