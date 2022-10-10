package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author ZM.Wang
 * 悬赏申请全额返还积分
 */
@Entity
public class ApplyCancelRewardRemand extends BaseEntity {

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private RewardDemand rewardDemand;

    private String reason;

    @Enumerated(EnumType.STRING)
    private ApplyStatus status;

    private Date completedAt;

    /** 驳回原因 */
    private String rejectionReason;

    public ApplyCancelRewardRemand(User user, RewardDemand rewardDemand, String reason) {
        this.user = user;
        this.rewardDemand = rewardDemand;
        this.reason = reason;
        this.status = ApplyStatus.UNTREATED;
    }

    public ApplyCancelRewardRemand pass() {
        this.status = ApplyStatus.PASS;
        this.completedAt = new Date();
        return this;
    }

    public ApplyCancelRewardRemand notPass(String rejectionReason) {
        this.status = ApplyStatus.NOT_PASS;
        this.completedAt = new Date();
        this.rejectionReason = rejectionReason;
        return this;
    }

    ApplyCancelRewardRemand() {
    }

    public User getUser() {
        return user;
    }

    public RewardDemand getRewardDemand() {
        return rewardDemand;
    }

    public String getReason() {
        return reason;
    }

    public ApplyStatus getStatus() {
        return status;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public Date getCompletedAt() {
        return completedAt;
    }
}
