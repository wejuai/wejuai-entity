package com.wejuai.entity.mongo;

public enum AppType {

    ARTICLE("article", "文章"),
    ARTICLE_DRAFT("articleDraft", "草稿"),
    REWARD_DEMAND("rewardDemand", "悬赏");
//    GROUP_BUYING("groupBuying");

    private final String reqPath;
    private final String name;

    AppType(String reqPath, String name) {
        this.reqPath = reqPath;
        this.name = name;
    }

    public String getReqPath() {
        return reqPath;
    }

    public String getName() {
        return name;
    }
}
