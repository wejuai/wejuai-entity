package com.wejuai.entity.mysql;

import com.wejuai.entity.mongo.AppType;
import com.wejuai.exception.IllegalParameterException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

/**
 * @author ZM.Wang
 * 需求悬赏
 */
@Entity
public class RewardDemand extends App<RewardDemand> {

    private String inShort;     //缩略文本

    @Column(columnDefinition = "TEXT")
    private String text;

    /** 截止日期 */
    private LocalDate deadline;

    /** 是否延期过 */
    private boolean extension;

    @Enumerated(EnumType.STRING)
    private RewardDemandStatus status;

    /** 评分限制 */
    private double scoreLimit;

    /** 总回答数 */
    private long rewardSubmissionCount;

    public RewardDemand update(String title, String inShort, String text) {
        super.title = title;
        this.inShort = inShort;
        this.text = text;
        return this;
    }

    public RewardDemand addIntegral(long integral) {
        if (integral < 0) {
            throw new IllegalParameterException("积分必须大于0");
        }
        super.integral += integral;
        return this;
    }

    public RewardDemand(User user, long integral) {
        super.user = user;
        super.integral = integral;
        this.deadline = LocalDate.now().plusMonths(1);
        this.status = RewardDemandStatus.NORMAL;
    }

    public RewardDemand setScoreLimit(double scoreLimit) {
        this.scoreLimit = scoreLimit;
        return this;
    }

    public RewardDemand extension() {
        this.extension = true;
        this.deadline = deadline.plusDays(15);
        return this;
    }

    public RewardDemand setRewardSubmissionCount(long rewardSubmissionCount) {
        this.rewardSubmissionCount = rewardSubmissionCount;
        return this;
    }

    public RewardDemand addText(String addText) {
        this.text += addText;
        return this;
    }

    @Override
    public RewardDemand setHobby(Hobby hobby) {
        super.setHobby(hobby);
        return this;
    }

    RewardDemand() {
    }

    public String getInShort() {
        return inShort;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean getExtension() {
        return extension;
    }

    public double getScoreLimit() {
        return scoreLimit;
    }

    public long getRewardSubmissionCount() {
        return rewardSubmissionCount;
    }

    public RewardDemandStatus getStatus() {
        return status;
    }

    public RewardDemand setStatus(RewardDemandStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public AppType getAppType() {
        return AppType.REWARD_DEMAND;
    }
}
