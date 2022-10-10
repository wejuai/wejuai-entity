package com.wejuai.entity.mysql;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ZM.Wang
 * 用户爱好管理
 */
@Entity
public class UserHobby extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    /** 用户所有的爱好 */
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Hobby> hobbies;

    /** 用户公开的爱好 */
    @ManyToMany(fetch = FetchType.LAZY)
    public Set<Hobby> openHobbies;

    public UserHobby(User user) {
        this.user = user;
    }

    public UserHobby addHobby(Hobby hobby) {
        if (hobbies == null) {
            hobbies = new HashSet<>();
        }
        hobbies.add(hobby);
        return this;
    }

    public UserHobby reduceHobby(Hobby hobby) {
        if (hobbies != null) {
            hobbies.remove(hobby);
        }
        return this;
    }

    public UserHobby addOpenHobby(Hobby hobby) {
        if (openHobbies == null) {
            openHobbies = new HashSet<>();
        }
        openHobbies.add(hobby);
        return this;
    }

    public UserHobby reduceOpenHobby(Hobby hobby) {
        if (openHobbies != null) {
            openHobbies.remove(hobby);
        }
        return this;
    }

    UserHobby() {
    }

    public User getUser() {
        return user;
    }

    public Set<Hobby> getHobbies() {
        return hobbies == null ? Collections.emptySet() : hobbies;
    }

    public Set<Hobby> getOpenHobbies() {
        return openHobbies == null ? Collections.emptySet() : openHobbies;
    }
}
