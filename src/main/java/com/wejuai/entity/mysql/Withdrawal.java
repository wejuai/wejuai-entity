package com.wejuai.entity.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author ZM.Wang
 * 提现记录
 */
@Entity
public class Withdrawal extends BaseEntity {

    private final static Logger logger = LoggerFactory.getLogger(Withdrawal.class);

    private long integral;

    @Enumerated(EnumType.STRING)
    private ApplyStatus status;

    /** 驳回原因 */
    private String rejectionReason;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    /** 审核时间 */
    private Date auditedAt;

    /** 转账时间 */
    private Date transferredAt;

    /** 通道订单号 */
    private String channelTradeId;

    /** 转账状态 */
    private boolean tradeStatus;

    @Enumerated(EnumType.STRING)
    private WithdrawalType channelType;

    private String name;

    private String cardNo;

    /** 最后一次转账记录id */
    private String lastTransferId;

    public Withdrawal(User user, long integral, WithdrawalType channelType) {
        this.integral = integral;
        this.status = ApplyStatus.UNTREATED;
        this.user = user;
        this.channelType = channelType;
    }

    public Withdrawal weixin(String openId) {
        this.cardNo = openId;
        return this;
    }

    public Withdrawal alipay(String name, String cardNo) {
        this.name = name;
        this.cardNo = cardNo;
        return this;
    }

    public Withdrawal review() {
        this.status = ApplyStatus.PASS;
        this.auditedAt = new Date();
        return this;
    }

    public Withdrawal rejection(String rejectionReason) {
        this.auditedAt = new Date();
        this.rejectionReason = rejectionReason;
        this.status = ApplyStatus.NOT_PASS;
        return this;
    }

    public String getTransferAmount() {
        return integral / 100d + "";
    }

    public Withdrawal complete(boolean status, String lastTransferId, String channelTradeId) {
        if (this.tradeStatus) {
            logger.warn("该提现已经成功");
            return this;
        }
        if (status) {
            this.tradeStatus = true;
            this.channelTradeId = channelTradeId;
        }
        this.lastTransferId = lastTransferId;
        this.transferredAt = new Date();
        return this;
    }

    Withdrawal() {
    }

    public long getIntegral() {
        return integral;
    }


    public User getUser() {
        return user;
    }

    public ApplyStatus getStatus() {
        return status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public Date getAuditedAt() {
        return auditedAt;
    }

    public String getChannelTradeId() {
        return channelTradeId;
    }

    public WithdrawalType getChannelType() {
        return channelType;
    }

    public String getName() {
        return name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getLastTransferId() {
        return lastTransferId;
    }

    public Date getTransferredAt() {
        return transferredAt;
    }

    public boolean getTradeStatus() {
        return tradeStatus;
    }
}
