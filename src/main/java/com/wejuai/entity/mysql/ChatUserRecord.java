package com.wejuai.entity.mysql;

import com.endofmaster.commons.id.IdGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ZM.Wang
 */
@Entity
public class ChatUserRecord {

    @Id
    @Column(length = 32)
    private String id;
    @Column(updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updateAt;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User sender;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User recipient;

    private LocalDateTime lastTime;

    private String lastText;

    /** 总消息数 */
    private long msgNum;

    /** 未读消息数 */
    private long unreadMsgNum;

    private boolean del;

    public ChatUserRecord(User sender, User recipient, String lastText) {
        this.id = IdGenerator.objectId();
        this.createdAt = new Date();
        this.updateAt = createdAt;
        this.sender = sender;
        this.recipient = recipient;
        this.lastTime = LocalDateTime.now();
        this.lastText = lastText;
    }

    public ChatUserRecord(String id, User sender, User recipient, String lastText) {
        this.id = id;
        this.createdAt = new Date();
        this.updateAt = createdAt;
        this.sender = sender;
        this.recipient = recipient;
        this.lastTime = LocalDateTime.now();
        this.lastText = lastText;
    }

    public ChatUserRecord setDel(boolean del) {
        this.del = del;
        return this;
    }

    public ChatUserRecord lastText(String lastText) {
        this.lastText = lastText;
        this.lastTime = LocalDateTime.now();
        return this;
    }

    public ChatUserRecord addMsg() {
        ++this.msgNum;
        ++this.unreadMsgNum;
        return this;
    }

    public ChatUserRecord watchMsg() {
        this.unreadMsgNum = 0;
        return this;
    }

    public ChatUserRecord watchMsg(long num) {
        this.unreadMsgNum -= num;
        return this;
    }

    ChatUserRecord() {
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public LocalDateTime getLastTime() {
        return lastTime;
    }

    public String getLastText() {
        return lastText;
    }

    public boolean getDel() {
        return del;
    }

    public long getMsgNum() {
        return msgNum;
    }

    public long getUnreadMsgNum() {
        return unreadMsgNum;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    @Override
    public String toString() {
        return "ChatUserRecord{" +
                "id='" + id + '\'' +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", unreadMsgNum=" + unreadMsgNum +
                '}';
    }
}
