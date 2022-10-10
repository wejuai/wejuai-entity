package com.wejuai.entity.mysql;

import com.wejuai.entity.mongo.AppType;
import com.wejuai.entity.mongo.trade.Charge;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author ZM.Wang
 * 积分普通操作订单
 */
@Entity
public class Orders extends BaseEntity {

    /** 收支类型 */
    @Enumerated(EnumType.STRING)
    private OrdersType type;

    /** 是否收入，false是支出 */
    private boolean income;

    @Enumerated(EnumType.STRING)
    private AppType appType;

    private String appId;

    private String goodsName;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private Article article;

    private long integral;

    /** 是否作废 */
    private boolean nullify;

    public Orders(OrdersType type, boolean income, App<?> app, User user) {
        this.type = type;
        this.income = income;
        this.user = user;
        this.appType = app.getAppType();
        this.appId = app.getId();
        this.goodsName = app.getTitle();
        this.integral = app.getIntegral();
        if (app instanceof Article) {
            this.article = (Article) app;
        }
    }

    public Orders(Charge charge, User user) {
        this.type = OrdersType.CHARGE;
        this.income = true;
        this.user = user;
        this.goodsName = "充值";
        this.integral = charge.getAmount();
    }

    public Orders(OrdersType type, User user, boolean income, long integral, String goodsName) {
        this.user = user;
        this.type = type;
        this.income = income;
        this.integral = integral;
        this.goodsName = goodsName;
    }

    public Orders(OrdersType type, boolean income, long integral, App<?> app, User user) {
        this.type = type;
        this.income = income;
        this.user = user;
        this.appType = app.getAppType();
        this.appId = app.getId();
        this.goodsName = app.getTitle();
        this.integral = integral;
        if (app instanceof Article) {
            this.article = (Article) app;
        }
    }

    Orders() {
    }

    public OrdersType getType() {
        return type;
    }

    public AppType getAppType() {
        return appType;
    }

    public String getAppId() {
        return appId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public User getUser() {
        return user;
    }

    public long getIntegral() {
        return integral;
    }

    public boolean getIncome() {
        return income;
    }

    public boolean getNullify() {
        return nullify;
    }

    public Orders setNullify(boolean nullify) {
        this.nullify = nullify;
        return this;
    }

    public Article getArticle() {
        return article;
    }
}
