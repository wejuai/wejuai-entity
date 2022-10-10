package com.wejuai.entity.mysql;

import com.wejuai.entity.mongo.AppType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 评价
 */
@Entity
public class Evaluate extends BaseEntity {

    private long score;//评分

    @Enumerated(EnumType.STRING)
    private AppType appType;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private Orders orders;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private RewardSubmission rewardSubmission;

    //评价者
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User evaluator;

    private String content;

    public Evaluate(AppType appType, long score, User evaluator, String content) {
        this.appType = appType;
        this.score = score;
        this.evaluator = evaluator;
        this.content = content;
    }

    public Evaluate setOrders(Orders orders) {
        this.orders = orders;
        return this;
    }

    public Evaluate setRewardSubmission(RewardSubmission rewardSubmission) {
        this.rewardSubmission = rewardSubmission;
        return this;
    }

    Evaluate() {
    }

    public long getScore() {
        return score;
    }

    public User getEvaluator() {
        return evaluator;
    }

    public String getContent() {
        return content;
    }

    public Orders getOrders() {
        return orders;
    }

    public AppType getAppType() {
        return appType;
    }

    public RewardSubmission getRewardSubmission() {
        return rewardSubmission;
    }
}
