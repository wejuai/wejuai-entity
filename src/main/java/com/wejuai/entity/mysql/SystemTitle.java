package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 系统公共头衔
 */
@Entity
public class SystemTitle extends BaseEntity {

    private String name;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private Image avatar;
    private String description;

    public SystemTitle(String name, Image avatar, String description) {
        this.name = name;
        this.avatar = avatar;
        this.description = description;
    }

    SystemTitle() {
    }

    public String getName() {
        return name;
    }

    public Image getAvatar() {
        return avatar;
    }

    public String getDescription() {
        return description;
    }
}
