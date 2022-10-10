package com.wejuai.entity.mysql;

import com.wejuai.entity.mongo.AppType;

import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * @author ZM.Wang
 */
@MappedSuperclass
public abstract class App<T extends App<T>> extends BaseEntity {

    private long displayNum;
    long starNum;
    long collectNum;
    /** 评论数 */
    long commentNum;
    @NotNull
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    User user;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    Hobby hobby;
    String title;
    /** 需求积分 */
    long integral;

    private boolean del;

    @SuppressWarnings("unchecked")
    public T collect() {
        ++this.collectNum;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T comment() {
        ++this.commentNum;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T watch() {
        ++this.displayNum;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T giveStar() {
        ++this.starNum;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T unCollect() {
        --this.collectNum;
        this.collectNum = collectNum < 0 ? 0 : collectNum;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T unGiveStar() {
        --this.starNum;
        this.starNum = starNum < 0 ? 0 : starNum;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T unComment() {
        --this.commentNum;
        this.commentNum = commentNum < 0 ? 0 : commentNum;
        return (T) this;
    }

    public long getDisplayNum() {
        return displayNum;
    }

    @SuppressWarnings("unchecked")
    public T setDisplayNum(long displayNum) {
        this.displayNum = displayNum;
        return (T) this;
    }

    public long getStarNum() {
        return starNum;
    }

    @SuppressWarnings("unchecked")
    public T setStarNum(long starNum) {
        this.starNum = starNum;
        return (T) this;
    }

    public long getCollectNum() {
        return collectNum;
    }

    @SuppressWarnings("unchecked")
    public T setCollectNum(long collectNum) {
        this.collectNum = collectNum;
        return (T) this;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unchecked")
    public T setTitle(String title) {
        this.title = title;
        return (T) this;
    }

    public Hobby getHobby() {
        return hobby;
    }

    @SuppressWarnings("unchecked")
    public T setHobby(Hobby hobby) {
        this.hobby = hobby;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T setUser(User user) {
        this.user = user;
        return (T) this;
    }

    public long getCommentNum() {
        return commentNum;
    }

    @SuppressWarnings("unchecked")
    public T setCommentNum(long commentNum) {
        this.commentNum = commentNum;
        return (T) this;
    }

    public boolean getDel() {
        return del;
    }

    @SuppressWarnings("unchecked")
    public T setDel(boolean del) {
        this.del = del;
        return (T) this;
    }

    public long getIntegral() {
        return integral;
    }

    @SuppressWarnings("unchecked")
    public T setIntegral(long integral) {
        this.integral = integral;
        return (T) this;
    }

    public abstract AppType getAppType();
}
