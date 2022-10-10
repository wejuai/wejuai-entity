package com.wejuai.entity.mysql;

import com.wejuai.entity.mongo.AppType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

import static com.wejuai.entity.mongo.AppType.ARTICLE_DRAFT;

/**
 * @author ZM.Wang
 * 文章草稿
 */
@Entity
public class ArticleDraft extends App<ArticleDraft> {

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    @NotFound(action= NotFoundAction.IGNORE)
    private Image cover; //封面图片的对象
    private String inShort;     //缩略文本

    @Column(columnDefinition = "TEXT")
    private String text;

    /** 购买后给购买者发送邮件内容 */
    @Column(columnDefinition = "TEXT")
    private String emailText;

    public ArticleDraft update(Hobby hobby, String title, Image cover, String inShort, String text, long integral, String emailText) {
        super.hobby = hobby;
        super.integral = integral;
        super.title = title;
        this.cover = cover;
        this.inShort = inShort;
        this.text = text;
        this.emailText = emailText;
        return this;
    }

    public Article publishArticle() {
        Article article = new Article(super.getUser());
        return article.update(super.getTitle(), this.cover, this.inShort, this.text, super.getIntegral(), this.emailText).setHobby(getHobby());
    }

    public ArticleDraft(User user) {
        setUser(user);
    }

    ArticleDraft() {
    }

    @Override
    public AppType getAppType() {
        return ARTICLE_DRAFT;
    }

    public Image getCover() {
        return cover;
    }

    public String getInShort() {
        return inShort;
    }

    public String getText() {
        return text;
    }

    public String getEmailText() {
        return emailText;
    }
}
