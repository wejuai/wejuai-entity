package com.wejuai.entity.mysql;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZM.Wang
 * 收支来源类型
 */
public enum OrdersType {

    ARTICLE("文章"),
    CHARGE("充值"),
    CASH_WITHDRAWAL("提现"),
    CASH_WITHDRAWAL_RETURN("提现退回"),
    REWARD_DEMAND("发布悬赏"),
    ADD_REWARD("增加悬赏金"),
    SELECTED_REWARD("选定悬赏"),
    SYSTEM_ADD("系统发放"),
    SYSTEM_SUB("系统扣除"),
    REWARD_DEMAND_RETURN("取消悬赏退回"),
    REWARD_DEMAND_COMPENSATE("回答的悬赏取消补偿");

    private final String name;

    OrdersType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static List<OrdersType> earnIncome() {
        return Arrays.asList(ARTICLE, SELECTED_REWARD, REWARD_DEMAND_COMPENSATE);
    }

    public static List<OrdersType> nonEarnIncome() {
        return Arrays.asList(CHARGE, CASH_WITHDRAWAL_RETURN, SYSTEM_ADD, REWARD_DEMAND_RETURN);
    }
}
