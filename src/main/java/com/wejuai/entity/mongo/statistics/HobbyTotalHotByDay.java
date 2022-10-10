package com.wejuai.entity.mongo.statistics;

import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author ZM.Wang
 */
public class HobbyTotalHotByDay {

    @Id
    private String id;

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

    public HobbyTotalHotByDay(long watched, long commented, long created, long followed, long unfollowed) {
        this.date = LocalDate.now().plusDays(-1);
        this.watched = watched;
        this.commented = commented;
        this.created = created;
        this.followed = followed;
        this.unfollowed = unfollowed;
    }

    public HobbyTotalHotByDay(LocalDate localDate) {
        this.date = localDate;
    }

    public HobbyTotalHotByDay addWatched() {
        ++this.watched;
        return this;
    }

    public HobbyTotalHotByDay addCommented() {
        ++this.commented;
        return this;
    }

    public HobbyTotalHotByDay addCreated() {
        ++this.created;
        return this;
    }

    public HobbyTotalHotByDay addFollowed() {
        ++this.followed;
        return this;
    }

    public HobbyTotalHotByDay addUnfollowed() {
        ++this.unfollowed;
        return this;
    }

    public HobbyTotalHotByDay subCommented() {
        --this.commented;
        return this;
    }

    public HobbyTotalHotByDay subCreated() {
        --this.created;
        return this;
    }

    public HobbyTotalHotByDay setWatched(long watched) {
        this.watched = watched;
        return this;
    }

    public HobbyTotalHotByDay setCommented(long commented) {
        this.commented = commented;
        return this;
    }

    public HobbyTotalHotByDay setCreated(long created) {
        this.created = created;
        return this;
    }

    public HobbyTotalHotByDay setFollowed(long followed) {
        this.followed = followed;
        return this;
    }

    public HobbyTotalHotByDay setUnfollowed(long unfollowed) {
        this.unfollowed = unfollowed;
        return this;
    }

    HobbyTotalHotByDay() {
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

    public LocalDate getDate() {
        return date;
    }

    public long getUnfollowed() {
        return unfollowed;
    }
}
