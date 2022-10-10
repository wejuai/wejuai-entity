package com.wejuai.entity.mongo.statistics;

import com.endofmaster.commons.id.IdGenerator;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * @author ZM.Wang
 * 积分订单统计
 */
public class OrdersStatisticsByDay {

    private String id;

    private LocalDate date;

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

    public OrdersStatisticsByDay(long articleCount, long articleAmount, long rewardDemandCount, long rewardDemandAmount, long transferAddCount, long transferAddAmount, long transferSubCount, long transferSubAmount) {
        this.id = IdGenerator.objectId();
        //定时任务是第二天凌晨执行
        this.date = LocalDate.now().plusDays(-1);
        this.articleCount = articleCount;
        this.articleAmount = articleAmount;
        this.rewardDemandCount = rewardDemandCount;
        this.rewardDemandAmount = rewardDemandAmount;
        this.transferAddCount = transferAddCount;
        this.transferAddAmount = transferAddAmount;
        this.transferSubCount = transferSubCount;
        this.transferSubAmount = transferSubAmount;
    }

    public OrdersStatisticsByDay update(long articleCount, long articleAmount, long rewardDemandCount, long rewardDemandAmount, long transferAddCount, long transferAddAmount, long transferSubCount, long transferSubAmount) {
        this.articleCount = articleCount;
        this.articleAmount = articleAmount;
        this.rewardDemandCount = rewardDemandCount;
        this.rewardDemandAmount = rewardDemandAmount;
        this.transferAddCount = transferAddCount;
        this.transferAddAmount = transferAddAmount;
        this.transferSubCount = transferSubCount;
        this.transferSubAmount = transferSubAmount;
        return this;
    }

    OrdersStatisticsByDay() {
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
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

    @Override
    public String toString() {
        return "OrdersStatisticsByDay{" +
                "id='" + id + '\'' +
                ", createdAt=" + date +
                ", articleCount=" + articleCount +
                ", articleAmount=" + articleAmount +
                ", rewardDemandCount=" + rewardDemandCount +
                ", rewardDemandAmount=" + rewardDemandAmount +
                ", transferAddCount=" + transferAddCount +
                ", transferAddAmount=" + transferAddAmount +
                ", transferSubCount=" + transferSubCount +
                ", transferSubAmount=" + transferSubAmount +
                '}';
    }
}
