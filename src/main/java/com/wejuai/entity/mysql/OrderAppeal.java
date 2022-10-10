package com.wejuai.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author ZM.Wang
 * 订单申诉
 */
@Entity
public class OrderAppeal extends BaseEntity {

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    @Enumerated(EnumType.STRING)
    private OrdersPageType type;

    private String typeId;

    /** 遇到的问题 */
    @Column(columnDefinition = "TEXT")
    private String question;

    @Enumerated(EnumType.STRING)
    private ApplyStatus status;

    private Date completedAt;

    /** 驳回原因 */
    private String rejectionReason;

    public OrderAppeal(User user, OrdersPageType type, String typeId, String question) {
        this.user = user;
        this.type = type;
        this.typeId = typeId;
        this.question = question;
        this.status = ApplyStatus.UNTREATED;
    }

    public OrderAppeal pass() {
        this.status = ApplyStatus.PASS;
        this.completedAt = new Date();
        return this;
    }

    public OrderAppeal notPass(String rejectionReason) {
        this.status = ApplyStatus.NOT_PASS;
        this.completedAt = new Date();
        this.rejectionReason = rejectionReason;
        return this;
    }

    OrderAppeal() {
    }

    public ApplyStatus getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public OrdersPageType getType() {
        return type;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getQuestion() {
        return question;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public Date getCompletedAt() {
        return completedAt;
    }
}
