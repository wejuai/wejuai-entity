package com.wejuai.entity.mongo.trade;

import com.wejuai.entity.mysql.ChannelType;
import org.apache.commons.lang3.Validate;

/**
 * @author ZM.Wang
 * 支付订单
 */
public class Charge extends Trade {

    private String subject;

    public Charge(String id, String userId, long amount, String subject, ChannelType channelType, String returnUrl, String notifyUrl) {
        super(id, userId, amount, channelType, returnUrl, notifyUrl);
        Validate.notBlank(subject);
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charge charge = (Charge) o;
        return id.equals(charge.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                '}';
    }

    public String getSubject() {
        return subject;
    }
}
