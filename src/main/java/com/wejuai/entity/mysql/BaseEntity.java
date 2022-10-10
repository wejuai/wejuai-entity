package com.wejuai.entity.mysql;

import com.endofmaster.commons.id.IdGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZM.Wang
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(length = 32)
    String id;
    @Column(updatable = false)
    private Date createdAt;
    @Version
    private long version;

    @UpdateTimestamp
    private Date updateAt;

    public BaseEntity() {
        this.id = IdGenerator.objectId();
        this.createdAt = new Date();
        this.updateAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public BaseEntity setId(String id) {
        this.id = id;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public BaseEntity setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @PreUpdate
    private void updated() {
        updateAt = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
