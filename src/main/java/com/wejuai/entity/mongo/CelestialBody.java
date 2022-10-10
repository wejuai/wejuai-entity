package com.wejuai.entity.mongo;

import com.wejuai.exception.IllegalParameterException;
import org.apache.commons.lang3.RandomUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author ZM.Wang
 */
public class CelestialBody extends BaseEntity {

    /**
     * 星球类型
     * 用户是行星，爱好是恒星
     */
    private CelestialBodyType type;

    /** 用户星球的用户 */
    private String user;

    /** 爱好星球的爱好 */
    private String hobby;

    /**
     * 用户贡献点，根据这个计算星球大小
     * 1个阅读数是1点
     * 每日登录5点
     * 1个评论数是1点
     * 购买文章和被购买文章1点积分是10点
     * 悬赏是发布和确定的人获得积分的10点
     * 前三个每天上限50点，后面两个500点
     * 10000贡献点为1km 90km需要100w
     * 使用点数同样会减少星球大小
     *
     * @see com.wejuai.entity.mongo.UserPointRecord 点数记录, 只有用户有，爱好的只有统计
     * 星球热度值, 根据这个计算星球大小
     * 阅读数:1点，评论数：1点，创建数：1点，关注数：2点
     * 如果删除或者取关同样会减少
     * 10000点为1km 90km需要100w
     * 创建时默认大小为10km
     * 星球最大100km再大开始加光圈
     */
    private long point;

    /**
     * 星球坐标
     * 一点坐标值为100km, 星球之间间隔在4到6个之间
     */
    private double x;
    /** 星球坐标 */
    private double y;

    /**
     * 星球北京大图OssKey
     * big替换为small就是小图OssKey
     */
    private String background;

    /** 星球图案大图OssKey */
    private String texture;

    /**
     * 花纹在背景上根据圆心旋转的角度
     */
    private int angle;

    public CelestialBody(CelestialBodyType type, String id, double x, double y) {
        this(x, y);
        this.type = type;
        if (type == CelestialBodyType.USER) {
            this.user = id;
        } else if (type == CelestialBodyType.HOBBY) {
            this.hobby = id;
        }
    }

    private CelestialBody(double x, double y) {
        this.x = x;
        this.y = y;
        this.point = 0;
    }

    public CelestialBody cancelAccount() {
        if (this.type != CelestialBodyType.USER) {
            throw new IllegalParameterException("该星球不是用户星球");
        }
        this.type = CelestialBodyType.UNOWNED;
        this.user = null;
        return this;
    }

    public long getSize() {
        long point = this.point / 25000;
        if (type == CelestialBodyType.USER) {
            return point + 50;
        } else if (type == CelestialBodyType.HOBBY) {
            return point + 70;
        }
        return 20;
    }

    public CelestialBody updateImage(String background, String texture, int angle) {
        this.background = background;
        this.texture = texture;
        this.angle = angle;
        return this;
    }

    public CelestialBody addPoint(long point) {
        if (point < 0) {
            throw new IllegalParameterException("参数不能低于0");
        }
        this.point += point;
        return this;
    }

    public CelestialBody cutPoint(long point) {
        if (point < 0) {
            throw new IllegalParameterException("参数不能低于0");
        }
        if (point > this.point && type == CelestialBodyType.USER) {
            throw new IllegalParameterException("抱歉您没有那么多贡献点");
        }
        this.point -= point;
        if (this.point < 0) {
            this.point = 0;
        }
        return this;
    }

    public CelestialBody setPoint(long point) {
        this.point = point;
        return this;
    }

    CelestialBody() {
    }

    public String getUser() {
        return user;
    }

    public long getPoint() {
        return point;
    }

    public CelestialBodyType getType() {
        return type;
    }

    public String getHobby() {
        return hobby;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getBackground() {
        return background;
    }

    public String getTexture() {
        return texture;
    }

    public int getAngle() {
        return angle;
    }

    @Override
    public String toString() {
        return "CelestialBody{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", user='" + user + '\'' +
                ", hobby='" + hobby + '\'' +
                ", point=" + point +
                ", x=" + x +
                ", y=" + y +
                ", background='" + background + '\'' +
                ", texture='" + texture + '\'' +
                ", angle=" + angle +
                '}';
    }
}