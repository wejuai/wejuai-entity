package com.wejuai.entity.mongo;

import javax.persistence.Id;

/**
 * @author ZM.Wang
 * 星球统计，总星域范围
 * 坐标是原点0开始的，坐标值1格为100km，星球最大100km，加上光圈或者其他东西最起码算2格，间隔一般3，4随机
 * 起点定为全值都是1，而不是0
 */
public class CelestialBodyStatistics {

    @Id
    private String id;

    /** 四个象限的圈数 */
    private long quadrant1;
    private long quadrant2;
    private long quadrant3;
    private long quadrant4;

    private long amount;

    public CelestialBodyStatistics(String id) {
        this.id = "CelestialBodyStatistics";
        this.amount = 0;
        this.quadrant1 = 2;
        this.quadrant2 = 2;
        this.quadrant3 = 2;
        this.quadrant4 = 2;
    }

    public CelestialBodyStatistics addQuadrantIndex(boolean x, boolean y) {
        if (x) {
            if (y) {
                ++this.quadrant1;
            } else {
                ++this.quadrant4;
            }
        } else {
            if (y) {
                ++this.quadrant2;
            } else {
                ++this.quadrant3;
            }
        }
        return this;
    }

    public long getQuadrantIndex(boolean x, boolean y) {
        if (x) {
            if (y) {
                return quadrant1;
            } else {
                return quadrant4;
            }
        } else {
            if (y) {
                return quadrant2;
            } else {
                return quadrant3;
            }
        }
    }

    public CelestialBodyStatistics addAmount() {
        ++this.amount;
        return this;
    }

    CelestialBodyStatistics() {
    }

    public long getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public long getQuadrant1() {
        return quadrant1;
    }

    public long getQuadrant2() {
        return quadrant2;
    }

    public long getQuadrant3() {
        return quadrant3;
    }

    public long getQuadrant4() {
        return quadrant4;
    }
}
