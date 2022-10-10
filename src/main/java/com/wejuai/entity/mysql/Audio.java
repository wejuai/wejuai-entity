package com.wejuai.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * @author ZM.Wang
 */
@Entity
public class Audio {

    @Id
    @Column(length = 32)
    private String id;

    private Date createdAt;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    private AudioUploadType type;

    private String ossKey;

    public Audio(String ossKey) {
        this.createdAt = new Date();
        this.ossKey = ossKey;
        this.type = AudioUploadType.valueOf(ossKey.substring(ossKey.indexOf("/") + 1, ossKey.indexOf("/", ossKey.indexOf("/") + 1)));
    }

    public Audio setUser(User user) {
        this.user = user;
        return this;
    }

    Audio() {
    }

    public String getOssKey() {
        return ossKey;
    }

    public User getUser() {
        return user;
    }

    public AudioUploadType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
