package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 用户头衔
 */
@Entity
public class Title extends BaseEntity {

    private String name;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private Image avatar;
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;
    private String description;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private SystemTitle systemTitle;

    public Title(String name, Image avatar, User user, String description) {
        this.name = name;
        this.avatar = avatar;
        this.user = user;
        this.description = description;
    }

    public Title(SystemTitle systemTitle) {
        this.systemTitle = systemTitle;
    }

    Title() {
    }

    public String getName() {
        return name;
    }

    public Image getAvatar() {
        return avatar;
    }

    public User getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public SystemTitle getSystemTitle() {
        return systemTitle;
    }
}
