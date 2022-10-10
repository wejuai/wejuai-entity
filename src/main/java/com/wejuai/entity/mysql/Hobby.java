package com.wejuai.entity.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Hobby {

    @Id
    @Column(length = 32)
    private String id;
    private String name;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private Image avatar;
    private Date createAt;
    private String domain;

    public Hobby(String id, String name, String domain) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.createAt = new Date();
    }

    public Hobby(String id, String name) {
        this.id = id;
        this.name = name;
        this.domain = id + ".wejuai.com";
        this.createAt = new Date();
    }

    public Hobby(String id) {
        this.id = id;
    }

    Hobby() {
    }

    public Hobby setAvatar(Image avatar) {
        this.avatar = avatar;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDomain() {
        return domain;
    }

    public Image getAvatar() {
        return avatar;
    }

    public Date getCreateAt() {
        return createAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return Objects.equals(id, hobby.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", avatar=" + avatar +
                ", createAt=" + createAt +
                ", domain='" + domain + '\'' +
                '}';
    }
}
