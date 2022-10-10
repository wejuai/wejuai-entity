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
public class Video {

    @Id
    @Column(length = 32)
    private String id;

    private Date createdAt;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    private VideoUploadType type;

    private String ossKey;

    public Video(String ossKey) {
        this.createdAt = new Date();
        this.ossKey = ossKey;
        this.type = VideoUploadType.valueOf(ossKey.substring(ossKey.indexOf("/") + 1, ossKey.indexOf("/", ossKey.indexOf("/") + 1)));
    }

    public Video setUser(User user) {
        this.user = user;
        return this;
    }

    Video() {
    }

    public String getOssKey() {
        return ossKey;
    }

    public User getUser() {
        return user;
    }

    public VideoUploadType getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
