package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class Problem extends BaseEntity {

    private String service;

    private String content;

    public Problem(String service, String content) {
        this.service = service;
        this.content = content;
    }

    Problem() {
    }

    public String getService() {
        return service;
    }

    public String getContent() {
        return content;
    }
}
