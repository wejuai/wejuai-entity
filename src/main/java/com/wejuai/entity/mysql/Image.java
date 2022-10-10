package com.wejuai.entity.mysql;

import com.endofmaster.commons.id.IdGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZM.Wang
 */
@Entity
public class Image {

    @Id
    @Column(length = 32)
    private String id;
    private Date createdAt;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;
    private String ossKey;
    @Enumerated(EnumType.STRING)
    private ImageUploadType type;

    public Image(User user, String ossKey) {
        this.id = IdGenerator.objectId();
        this.createdAt = new Date();
        this.user = user;
        this.ossKey = ossKey;
        this.type = ImageUploadType.valueOf(ossKey.substring(ossKey.indexOf("/") + 1, ossKey.indexOf("/", ossKey.indexOf("/") + 1)));
    }

    public Image setUser(User user) {
        this.user = user;
        return this;
    }

    public Image(String id) {
        this.id = id;
    }

    public Image(String ossKey, boolean key) {
        this.id = IdGenerator.objectId();
        this.ossKey = ossKey;
        this.createdAt = new Date();
        this.type = ImageUploadType.valueOf(ossKey.substring(ossKey.indexOf("/") + 1, ossKey.indexOf("/", ossKey.indexOf("/") + 1)));
    }

    public Image(String id, String ossKey, ImageUploadType type) {
        this.id = id;
        this.ossKey = ossKey;
        this.createdAt = new Date();
        this.type = type;
    }

    public Image(String ossKey, ImageUploadType type) {
        this.id = IdGenerator.objectId();
        this.createdAt = new Date();
        this.ossKey = ossKey;
        this.type = type;
    }

    Image() {
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public String getOssKey() {
        return ossKey;
    }

    public ImageUploadType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(id, image.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", ossKey='" + ossKey + '\'' +
                ", type=" + type +
                '}';
    }
}
