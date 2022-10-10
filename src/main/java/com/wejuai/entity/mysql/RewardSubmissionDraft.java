package com.wejuai.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 悬赏回答草稿
 */
@Entity
public class RewardSubmissionDraft extends BaseEntity {

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private RewardDemand rewardDemand;

    /** 悬赏选定前内容 */
    @Column(columnDefinition = "TEXT")
    private String inShort;

    /** 完整内容 */
    @Column(columnDefinition = "TEXT")
    private String text;

    public RewardSubmissionDraft(User user, RewardDemand rewardDemand) {
        this.user = user;
        this.rewardDemand = rewardDemand;
    }

    public RewardSubmissionDraft(RewardSubmission rewardSubmission) {
        this.user = rewardSubmission.getUser();
        this.rewardDemand = rewardSubmission.getRewardDemand();
        this.inShort = rewardSubmission.getInShort();
        this.text = rewardSubmission.getText();
    }

    RewardSubmissionDraft() {
    }

    public RewardSubmissionDraft setInShort(String inShort) {
        this.inShort = inShort;
        return this;
    }

    public RewardSubmissionDraft setText(String text) {
        this.text = text;
        return this;
    }

    public User getUser() {
        return user;
    }

    public RewardDemand getRewardDemand() {
        return rewardDemand;
    }

    public String getInShort() {
        return inShort;
    }

    public String getText() {
        return text;
    }
}
