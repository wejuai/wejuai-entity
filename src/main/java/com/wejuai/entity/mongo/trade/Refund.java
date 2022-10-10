//package com.wejuai.entity.mongo.trade;
//
//
//import com.wejuai.entity.mysql.ChannelType;
//
//import java.util.Map;
//
///**
// * @author YQ.Huang
// */
//public class Refund extends Trade {
//
//    private final String chargeId;
//
//    public Refund(String orderId, long amount, ChannelType channelType, String remark, String metadata, Map<String, Object> extraParams,
//                  String notifyUrl, String callbackUrl, String chargeId) {
//        super(orderId, amount, channelType, remark, metadata, extraParams, callbackUrl, notifyUrl);
//        this.chargeId = chargeId;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Refund refund = (Refund) o;
//        return id.equals(refund.id);
//
//    }
//
//    @Override
//    public int hashCode() {
//        return id.hashCode();
//    }
//
//    @Override
//    public String toString() {
//        return "Refund{" +
//                "id=" + id +
//                '}';
//    }
//
//    public String getChargeId() {
//        return chargeId;
//    }
//}