package com.wejuai.entity.mongo;

import com.endofmaster.commons.id.IdGenerator;

import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * @author ZM.Wang
 */
public abstract class BaseEntity {

    @Id
    protected String id;
    private Date createdAt;

    BaseEntity() {
        this.id = IdGenerator.objectId();
        this.createdAt = new Date();
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
