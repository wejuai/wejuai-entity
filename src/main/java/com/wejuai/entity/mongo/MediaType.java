package com.wejuai.entity.mongo;

public enum MediaType {

    IMAGE("[图片]"),
    VIDEO("[视频]"),
    AUDIO("[语音]");

    private final String text;

    MediaType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
