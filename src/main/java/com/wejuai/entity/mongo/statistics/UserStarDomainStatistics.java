package com.wejuai.entity.mongo.statistics;


import com.endofmaster.commons.id.IdGenerator;

/**
 * @author ZM.Wang
 */
public class UserStarDomainStatistics {

    private String id;
    private String userId;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;

    public UserStarDomainStatistics(String userId) {
        this.id = IdGenerator.uuid();
        this.userId = userId;
    }

    public UserStarDomainStatistics update(double minX, double maxX, double minY, double maxY) {
        this.minX = Math.min(minX, this.minX);
        this.maxX = Math.max(maxX, this.maxX);
        this.minY = Math.min(minY, this.minY);
        this.maxY = Math.max(maxY, this.maxY);
        return this;
    }

    UserStarDomainStatistics() {
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxX() {
        return maxX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }
}
