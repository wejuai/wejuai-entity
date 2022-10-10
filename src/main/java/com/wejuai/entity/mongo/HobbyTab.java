package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 */
public class HobbyTab extends BaseEntity {

    private String tab;
    private String hobbyId;

    public HobbyTab(String id, String tab, String hobbyId) {
        this.id = id;
        this.tab = tab;
        this.hobbyId = hobbyId;
    }

    HobbyTab() {
    }

    public String getTab() {
        return tab;
    }

    public String getHobbyId() {
        return hobbyId;
    }

    @Override
    public String toString() {
        return "HobbyTab{" +
                "tab='" + tab + '\'' +
                ", hobbyId='" + hobbyId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
