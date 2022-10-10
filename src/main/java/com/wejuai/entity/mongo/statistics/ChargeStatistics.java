package com.wejuai.entity.mongo.statistics;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author ZM.Wang
 * 现金统计
 */
public class ChargeStatistics {

    private String id;

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

    public ChargeStatistics(String id) {
        this.id = id;
        this.rechargeCount = 0;
        this.rechargeAmount = 0;
        this.transferCount = 0;
        this.transferAmount = 0;
        this.withdrawalCount = 0;
        this.withdrawalAmount = 0;
    }

    ChargeStatistics() {
    }

    public String getId() {
        return id;
    }

    public ChargeStatistics addRechargeCount() {
        ++this.rechargeCount;
        return this;
    }

    public ChargeStatistics addTransferCount() {
        ++this.transferCount;
        return this;
    }

    public ChargeStatistics addWithdrawalCount() {
        ++this.withdrawalCount;
        return this;
    }

    public ChargeStatistics addRechargeAmount(long amount) {
        this.rechargeAmount += amount;
        return this;
    }

    public ChargeStatistics addTransferAmount(long amount) {
        this.transferAmount += amount;
        return this;
    }

    public ChargeStatistics addWithdrawalAmount(long amount) {
        this.withdrawalAmount += amount;
        return this;
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
}
