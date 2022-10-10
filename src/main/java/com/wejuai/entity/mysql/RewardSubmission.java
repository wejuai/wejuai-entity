package com.wejuai.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 悬赏提交的内容
 */
@Entity
public class RewardSubmission extends BaseEntity {

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

    private boolean selected;

    public RewardSubmission(User user, RewardDemand rewardDemand) {
        this.selected = false;
        this.user = user;
        this.rewardDemand = rewardDemand;
    }

    public RewardSubmission(RewardSubmissionDraft rewardSubmissionDraft) {
        this.user = rewardSubmissionDraft.getUser();
        this.rewardDemand = rewardSubmissionDraft.getRewardDemand();
        this.inShort = rewardSubmissionDraft.getInShort();
        this.text = rewardSubmissionDraft.getText();
    }

    public RewardSubmission setText(String text) {
        this.text = text;
        return this;
    }

    public String getInShort() {
        return inShort;
    }

    public RewardSubmission setInShort(String inShort) {
        this.inShort = inShort;
        return this;
    }

    public RewardSubmission setSelected(boolean selected) {
        this.selected = selected;
        return this;
    }

    RewardSubmission() {
    }

    public User getUser() {
        return user;
    }

    public RewardDemand getRewardDemand() {
        return rewardDemand;
    }

    public String getText() {
        return text;
    }

    public boolean getSelected() {
        return selected;
    }
}
