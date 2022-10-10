package com.wejuai.entity.mongo;

/**
 * @author ZM.Wang
 * 坐标收藏
 */
public class Coordinate extends BaseEntity {

    private String userId;

    private double x;

    private double y;

    private String name;

    public Coordinate(String userId, double x, double y, String name) {
        this.userId = userId;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    Coordinate() {
    }

    public Coordinate setName(String name) {
        this.name = name;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }
}
