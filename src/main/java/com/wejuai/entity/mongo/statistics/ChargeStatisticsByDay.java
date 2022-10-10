package com.wejuai.entity.mongo.statistics;

import com.endofmaster.commons.id.IdGenerator;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * @author ZM.Wang
 * 现金统计
 */
public class ChargeStatisticsByDay {

    private String id;

    private LocalDate date;

    @ApiModelProperty("成功充值单数量")
    private long rechargeCount;
    @ApiModelProperty("成功充值单金额")
    private long rechargeAmount;
    @ApiModelProperty("直接转账数量")
    private long transferCount;
    @ApiModelProperty("直接转账金额")
    private long transferAmount;
    @ApiModelProperty("成功提现单数量")
    private long withdrawalCount;
    @ApiModelProperty("成功提现单金额")
    private long withdrawalAmount;

    public ChargeStatisticsByDay(long rechargeCount, long rechargeAmount, long transferCount, long transferAmount, long withdrawalCount, long withdrawalAmount) {
        this.id = IdGenerator.objectId();
        //定时任务是第二天凌晨执行
        this.date = LocalDate.now().plusDays(-1);
        this.rechargeCount = rechargeCount;
        this.rechargeAmount = rechargeAmount;
        this.transferCount = transferCount;
        this.transferAmount = transferAmount;
        this.withdrawalCount = withdrawalCount;
        this.withdrawalAmount = withdrawalAmount;
    }

    public ChargeStatisticsByDay update(long rechargeCount, long rechargeAmount, long transferCount, long transferAmount, long withdrawalCount, long withdrawalAmount) {
        this.rechargeCount = rechargeCount;
        this.rechargeAmount = rechargeAmount;
        this.transferCount = transferCount;
        this.transferAmount = transferAmount;
        this.withdrawalCount = withdrawalCount;
        this.withdrawalAmount = withdrawalAmount;
        return this;
    }

    ChargeStatisticsByDay() {
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getRechargeCount() {
        return rechargeCount;
    }

    public long getRechargeAmount() {
        return rechargeAmount;
    }

    public long getTransferCount() {
        return transferCount;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public long getWithdrawalCount() {
        return withdrawalCount;
    }

    public long getWithdrawalAmount() {
        return withdrawalAmount;
    }

    @Override
    public String toString() {
        return "ChargeStatisticsByDay{" +
                "id='" + id + '\'' +
                ", createdAt=" + date +
                ", rechargeCount=" + rechargeCount +
                ", rechargeAmount=" + rechargeAmount +
                ", transferCount=" + transferCount +
                ", transferAmount=" + transferAmount +
                ", withdrawalCount=" + withdrawalCount +
                ", withdrawalAmount=" + withdrawalAmount +
                '}';
    }
}
