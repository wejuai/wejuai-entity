package com.wejuai.entity.mongo;


/**
 * @author ZM.Wang
 * 控制台操作记录
 */
public class ConsoleOperationLog extends BaseEntity {

    /** 接口地址 */
    private String api;

    /** 方法 */
    private String method;

    /** 数据 */
    private String data;

    public ConsoleOperationLog(String api, String method, String data) {
        this.api = api;
        this.method = method;
        this.data = data;
    }

    ConsoleOperationLog() {
    }

    public String getApi() {
        return api;
    }

    public String getMethod() {
        return method;
    }

    public String getData() {
        return data;
    }
}
