package com.wejuai.entity.mongo.statistics;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ZM.Wang
 * 积分订单统计
 */
public class OrdersStatistics {

    private String id;

    @ApiModelProperty("有积分文章订单数量")
    private long articleCount;
    @ApiModelProperty("有积分文章订单积分数量")
    private long articleAmount;

    @ApiModelProperty("完成的悬赏订单数量")
    private long rewardDemandCount;
    @ApiModelProperty("完成的悬赏订单积分数量")
    private long rewardDemandAmount;

    @ApiModelProperty("直接转账积分单数量")
    private long transferAddCount;
    @ApiModelProperty("直接转账积分数量")
    private long transferAddAmount;

    @ApiModelProperty("直接扣除积分单数量")
    private long transferSubCount;
    @ApiModelProperty("直接扣除积分数量")
    private long transferSubAmount;

    public OrdersStatistics(String id) {
        this.id = id;
        this.articleCount = 0;
        this.articleAmount = 0;
        this.rewardDemandCount = 0;
        this.rewardDemandAmount = 0;
        this.transferAddCount = 0;
        this.transferAddAmount = 0;
        this.transferSubCount = 0;
        this.transferSubAmount = 0;
    }

    public OrdersStatistics addArticleCount() {
        ++this.articleCount;
        return this;
    }

    public OrdersStatistics addRewardDemandCount() {
        ++this.rewardDemandCount;
        return this;
    }

    public OrdersStatistics addTransferAddCount() {
        ++this.transferAddCount;
        return this;
    }

    public OrdersStatistics addTransferSubCount() {
        ++this.transferSubCount;
        return this;
    }

    public OrdersStatistics addArticleAmount(long amount) {
        this.articleAmount += amount;
        return this;
    }

    public OrdersStatistics addRewardDemandAmount(long amount) {
        this.rewardDemandAmount += amount;
        return this;
    }

    public OrdersStatistics addTransferAddAmount(long amount) {
        this.transferAddAmount += amount;
        return this;
    }

    public OrdersStatistics addTransferSubAmount(long amount) {
        this.transferSubAmount += amount;
        return this;
    }

    OrdersStatistics() {
    }

    public String getId() {
        return id;
    }

    public long getArticleCount() {
        return articleCount;
    }

    public long getArticleAmount() {
        return articleAmount;
    }

    public long getRewardDemandCount() {
        return rewardDemandCount;
    }

    public long getRewardDemandAmount() {
        return rewardDemandAmount;
    }

    public long getTransferAddCount() {
        return transferAddCount;
    }

    public long getTransferAddAmount() {
        return transferAddAmount;
    }

    public long getTransferSubCount() {
        return transferSubCount;
    }

    public long getTransferSubAmount() {
        return transferSubAmount;
    }
}
