package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 问题反馈
 */
@Entity
public class Feedback extends BaseEntity {

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;
    private String text;
    private String contact;
    private boolean handle;

    public Feedback(String text, String contact) {
        this.text = text;
        this.contact = contact;
        this.handle = false;
    }

    public User getUser() {
        return user;
    }

    public Feedback setUser(User user) {
        this.user = user;
        return this;
    }

    Feedback() {
    }

    public String getText() {
        return text;
    }

    public String getContact() {
        return contact;
    }

    public boolean getHandle() {
        return handle;
    }

    public Feedback handle() {
        this.handle = true;
        return this;
    }
}
