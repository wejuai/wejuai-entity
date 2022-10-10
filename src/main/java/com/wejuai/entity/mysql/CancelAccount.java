package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 */
@Entity
public class CancelAccount extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    private String reason;

    public CancelAccount(User user, String reason) {
        this.user = user;
        this.reason = reason;
    }

    CancelAccount() {
    }

    public User getUser() {
        return user;
    }

    public String getReason() {
        return reason;
    }
}
