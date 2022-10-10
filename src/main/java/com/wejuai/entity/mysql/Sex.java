package com.wejuai.entity.mysql;

import org.apache.commons.lang3.StringUtils;

public enum Sex {
    MAN("男"),
    WOMAN("女"),
    INTERSEX("你想要的那个");

    private final String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Sex find(String sex) {
        if (StringUtils.equals(sex, "男")) {
            return MAN;
        } else if (StringUtils.equals(sex, "女")) {
            return WOMAN;
        } else {
            return INTERSEX;
        }
    }

    public static Sex find(int sex) {
        if (sex == 1) {
            return MAN;
        } else if (sex == 2) {
            return WOMAN;
        } else {
            return INTERSEX;
        }
    }
}
