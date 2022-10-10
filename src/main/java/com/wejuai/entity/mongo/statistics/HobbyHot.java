package com.wejuai.entity.mongo.statistics;

import com.endofmaster.commons.id.IdGenerator;

import javax.persistence.Id;

/**
 * @author ZM.Wang
 * 爱好热度
 */
public class HobbyHot {

    @Id
    private String id;

    private String hobbyId;

    /** 阅读数 */
    private long watched;

    /** 评论数 */
    private long commented;

    /** 创建数 */
    private long created;

    /** 关注数 */
    private long followed;

    public HobbyHot(String hobbyId) {
        this.id = IdGenerator.objectId();
        this.hobbyId = hobbyId;
    }

    public HobbyHot addWatched() {
        ++this.watched;
        return this;
    }

    public HobbyHot addCommented() {
        ++this.commented;
        return this;
    }

    public HobbyHot addCreated() {
        ++this.created;
        return this;
    }

    public HobbyHot addFollowed() {
        ++this.followed;
        return this;
    }

    public HobbyHot addUnfollowed() {
        ++this.followed;
        return this;
    }

    public HobbyHot subCommented() {
        --this.commented;
        if (this.commented < 0) {
            this.commented = 0;
        }
        return this;
    }

    public HobbyHot subCreated() {
        --this.created;
        if (this.created < 0) {
            this.created = 0;
        }
        return this;
    }

    public HobbyHot subFollowed() {
        --this.followed;
        if (this.followed < 0) {
            this.followed = 0;
        }
        return this;
    }

    HobbyHot() {
    }

    public String getId() {
        return id;
    }

    public String getHobbyId() {
        return hobbyId;
    }

    public long getWatched() {
        return watched;
    }

    public long getCommented() {
        return commented;
    }

    public long getCreated() {
        return created;
    }

    public long getFollowed() {
        return followed;
    }
}
