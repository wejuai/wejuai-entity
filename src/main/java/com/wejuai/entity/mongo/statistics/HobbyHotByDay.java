package com.wejuai.entity.mongo.statistics;

import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author ZM.Wang
 */
public class HobbyHotByDay {

    @Id
    private String id;

    private String hobbyId;

    //阅读数
    private long watched;

    //评论数
    private long commented;

    //创建数
    private long created;

    //新关注数
    private long followed;

    /** 取消关注 */
    private long unfollowed;

    private LocalDate date;

    public HobbyHotByDay(String hobbyId, LocalDate date) {
        this.hobbyId = hobbyId;
        this.date = date;
        this.watched = 0;
        this.commented = 0;
        this.created = 0;
        this.followed = 0;
        this.unfollowed = 0;
    }

    public HobbyHotByDay addWatched() {
        ++this.watched;
        return this;
    }

    public HobbyHotByDay addCommented() {
        ++this.commented;
        return this;
    }

    public HobbyHotByDay addCreated() {
        ++this.created;
        return this;
    }

    public HobbyHotByDay addFollowed() {
        ++this.followed;
        return this;
    }

    public HobbyHotByDay addUnfollowed() {
        ++this.unfollowed;
        return this;
    }

    public HobbyHotByDay subCommented() {
        --this.commented;
        return this;
    }

    public HobbyHotByDay subCreated() {
        --this.created;
        return this;
    }

    HobbyHotByDay() {
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

    public LocalDate getDate() {
        return date;
    }

    public long getUnfollowed() {
        return unfollowed;
    }
}
