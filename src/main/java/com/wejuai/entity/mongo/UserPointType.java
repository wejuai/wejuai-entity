package com.wejuai.entity.mongo;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZM.Wang
 */
public enum UserPointType {

    /** 每天5点 */
    DAILY_LOGIN(5),
    /** 每天上限50 */
    WATCHED(50),
    COMMENTED(50),
    DEL_COMMENTED(50),

    /** 每日上限500 */
    BUY_ARTICLE(500),
    SELL_ARTICLE(500),
    /** 悬赏成功 */
    REWARD_DEMAND_SUCCESSFUL(500),
    /** 悬赏提交被选中 */
    BE_SELECTED_REWARD_DEMAND(500),

    /** 系统处理 */
    SYSTEM_ADD(0),
    SYSTEM_SUB(0);

    private final long upperLimitByDay;

    UserPointType(long upperLimitByDay) {
        this.upperLimitByDay = upperLimitByDay;
    }

    public long getUpperLimitByDay() {
        return upperLimitByDay;
    }

    public static List<UserPointType> addTypes() {
        return Arrays.asList(DAILY_LOGIN, WATCHED, BUY_ARTICLE, SELL_ARTICLE, REWARD_DEMAND_SUCCESSFUL, BE_SELECTED_REWARD_DEMAND, SYSTEM_ADD);
    }

    public static List<UserPointType> subTypes() {
        return Arrays.asList(SYSTEM_SUB);
    }
}
