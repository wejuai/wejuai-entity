package com.wejuai.entity.mysql;

import com.endofmaster.commons.id.IdGenerator;
import com.wejuai.exception.IllegalParameterException;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author ZM.Wang
 */
@Entity
public class User extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    private Accounts accounts;
    private String nickName;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    /** 简介 */
    private String inShort;
    private String location;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    @NotFound(action = NotFoundAction.IGNORE)
    private Image headImage;
    /** 封面 */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    @NotFound(action = NotFoundAction.IGNORE)
    private Image cover;
    /** 爱好数量 */
    private long hobbyNum;

    /** 消息数 */
    private long msgNum;
    /** 积分 */
    private long integral;
    /** 作为买家收到的总评分 */
    private long buyerScore;
    /** 购买次数 */
    private long buyerCount;
    /** 作为卖家收到的总评分 */
    private long sellerScore;
    /** 出售次数 */
    private long sellerCount;
    /** 是否隐藏隐私 */
    private boolean privacy = true;
    /** 用户手机性能 */
    @Enumerated(EnumType.STRING)
    private Performance performance;

    /** 是否封禁 */
    private boolean ban = false;
    /** 是否注销 */
    private boolean del = false;

    public User(Accounts accounts) {
        this(IdGenerator.objectId(), accounts);
    }

    public User(String id, Accounts accounts) {
        super.id = id;
        this.accounts = accounts;
        this.nickName = super.getCreatedAt().getTime() + "";
        this.performance = Performance.NEW;
    }

    public User(String id) {
        super.id = id;
        this.nickName = super.getCreatedAt().getTime() + "";
        this.performance = Performance.NEW;
    }

    public User cancelAccount() {
        this.del = true;
        this.nickName = "已注销";
        this.birthday = null;
        this.sex = null;
        this.inShort = null;
        this.location = null;
        this.headImage = null;
        this.cover = null;
        this.hobbyNum = 0;
        this.msgNum = 0;
        this.integral = 0;
        this.buyerScore = 0;
        this.buyerCount = 0;
        this.sellerScore = 0;
        this.sellerCount = 0;
        this.performance = null;
        return this;
    }

    public User addHobby() {
        this.hobbyNum += 1;
        return this;
    }

    public User reduceHobby() {
        this.hobbyNum -= 1;
        if (hobbyNum < 0) {
            hobbyNum = 0;
        }
        return this;
    }

    public String getBuyer() {
        double score = buyerScore + 250.0;
        long count = buyerCount + 50;
        return String.format("%.2f", score / count);
    }

    public String getSeller() {
        double score = sellerScore + 250.0;
        long count = sellerCount + 50;
        return String.format("%.2f", score / count);
    }

    public User buyEvaluate(long score) {
        ++this.buyerCount;
        this.buyerScore += score;
        return this;
    }

    public User sellEvaluate(long score) {
        ++this.sellerCount;
        this.sellerScore += score;
        return this;
    }

    public User addIntegral(long integral) {
        if (integral < 0) {
            throw new IllegalParameterException("参数不能低于0");
        }
        this.integral += integral;
        return this;
    }

    public User cutIntegral(long integral) {
        if (integral < 0) {
            throw new IllegalParameterException("参数不能低于0");
        }
        if (integral > this.integral) {
            throw new IllegalParameterException("抱歉您没有那么多积分");
        }
        this.integral -= integral;
        return this;
    }

    public User setPerformance(Performance performance) {
        this.performance = performance;
        return this;
    }

    public User setHeadImage(Image headImage) {
        this.headImage = headImage;
        return this;
    }

    public User setCover(Image cover) {
        this.cover = cover;
        return this;
    }

    public User setIntegral(long integral) {
        this.integral = integral;
        return this;
    }

    public User updateInfo(String nickName, LocalDate birthday, Sex sex, String inShort, String location) {
        this.nickName = nickName;
        this.birthday = birthday;
        this.sex = sex;
        this.inShort = inShort;
        this.location = location;
        return this;
    }

    public User addMsg() {
        ++this.msgNum;
        return this;
    }

    public User watchMsg() {
        --this.msgNum;
        if (this.msgNum < 0) {
            this.msgNum = 0;
        }
        return this;
    }

    public User watchMsg(long num) {
        this.msgNum -= num;
        if (this.msgNum < 0) {
            this.msgNum = 0;
        }
        return this;
    }

    public User setPrivacy(boolean privacy) {
        this.privacy = privacy;
        return this;
    }

    public User updateNickName(String nickName) {
        if (StringUtils.isBlank(nickName)) {
            this.nickName = nickName;
        }
        return this;
    }

    public User setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public User setMsgNum(long msgNum) {
        this.msgNum = msgNum;
        return this;
    }

    public boolean getDel() {
        return del;
    }

    public User setDel(boolean del) {
        this.del = del;
        return this;
    }

    User() {
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public String getNickName() {
        return nickName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public String getInShort() {
        return inShort;
    }

    public String getLocation() {
        return location;
    }

    public Image getHeadImage() {
        return headImage;
    }

    public long getMsgNum() {
        return msgNum;
    }

    public Image getCover() {
        return cover;
    }

    public long getIntegral() {
        return integral;
    }

    public boolean getPrivacy() {
        return privacy;
    }

    public long getBuyerScore() {
        return buyerScore;
    }

    public long getBuyerCount() {
        return buyerCount;
    }

    public long getSellerScore() {
        return sellerScore;
    }

    public long getSellerCount() {
        return sellerCount;
    }

    public Performance getPerformance() {
        return performance;
    }

    public long getHobbyNum() {
        return hobbyNum;
    }

    public boolean getBan() {
        return ban;
    }

    public User setBan(boolean ban) {
        this.ban = ban;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", ban=" + ban +
                ", del=" + del +
                '}';
    }
}
