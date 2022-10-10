package com.wejuai.entity.mongo.statistics;

import javax.persistence.Id;

/**
 * @author ZM.Wang
 */
public class HobbyTotalHot {

    @Id
    private final String id;

    //阅读数
    private long watched;

    //评论数
    private long commented;

    //创建数
    private long created;

    //关注数
    private long followed;

    public HobbyTotalHot(String id) {
        this.id = id;
    }

    public HobbyTotalHot addWatched(long watched) {
        this.watched += watched;
        return this;
    }

    public HobbyTotalHot addCommented(long commented) {
        this.commented += commented;
        return this;
    }

    public HobbyTotalHot addCreated(long created) {
        this.created += created;
        return this;
    }

    public HobbyTotalHot addFollowed(long followed) {
        this.followed += followed;
        return this;
    }

    public HobbyTotalHot setWatched(long watched) {
        this.watched = watched;
        return this;
    }

    public HobbyTotalHot setCommented(long commented) {
        this.commented = commented;
        return this;
    }

    public HobbyTotalHot setCreated(long created) {
        this.created = created;
        return this;
    }

    public HobbyTotalHot setFollowed(long followed) {
        this.followed = followed;
        return this;
    }

    public String getId() {
        return id;
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
