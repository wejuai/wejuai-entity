package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 区
 */
public class Region {

    private String id;
    private String name;
    private String pinyin;
    private String pid;

    public String getId() {
        return id;
    }

    public Region setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    public String getPinyin() {
        return pinyin;
    }

    public Region setPinyin(String pinyin) {
        this.pinyin = pinyin;
        return this;
    }

    public String getPid() {
        return pid;
    }

    public Region setPid(String pid) {
        this.pid = pid;
        return this;
    }
}
