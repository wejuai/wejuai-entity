package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class UserSearchTag extends BaseEntity {

    private String content;

    public UserSearchTag(String content) {
        this.content = content;
    }

    UserSearchTag() {
    }

    public String getContent() {
        return content;
    }
}
