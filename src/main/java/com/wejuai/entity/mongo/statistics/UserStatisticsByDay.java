package com.wejuai.entity.mongo.statistics;

import com.endofmaster.commons.id.IdGenerator;

import java.time.LocalDate;

/**
 * @author ZM.Wang
 */
public class UserStatisticsByDay {

    private String id;

    private LocalDate date;

    private long userRegister;

    private long imMsg;

    public UserStatisticsByDay(long userRegister, long imMsg) {
        this.id = IdGenerator.objectId();
        this.date = LocalDate.now().plusDays(-1);
        this.userRegister = userRegister;
        this.imMsg = imMsg;
    }

    public UserStatisticsByDay update(long userRegister, long imMsg) {
        this.userRegister = userRegister;
        this.imMsg = imMsg;
        return this;
    }

    UserStatisticsByDay() {
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getUserRegister() {
        return userRegister;
    }

    public long getImMsg() {
        return imMsg;
    }

    @Override
    public String toString() {
        return "UserStatisticsByDay{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", userRegister=" + userRegister +
                ", imMsg=" + imMsg +
                '}';
    }
}
