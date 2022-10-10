package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 关注记录 attention关注follow
 */
@Entity
public class Attention extends BaseEntity {

    //关注人
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User attention;
    //被关注人
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User follow;

    public Attention(User attention, User follow) {
        this.attention = attention;
        this.follow = follow;
    }

    Attention() {
    }

    public User getAttention() {
        return attention;
    }

    public User getFollow() {
        return follow;
    }
}
