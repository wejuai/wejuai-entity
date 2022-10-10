package com.wejuai.entity.mysql;

import com.wejuai.entity.mongo.AppType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * @author ZM.Wang
 * 文章
 */
@Entity
public class Article extends App<Article> {

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "none"))
    @NotFound(action= NotFoundAction.IGNORE)
    private Image cover; //封面图片的对象
    private String inShort;     //缩略文本

    @Column(columnDefinition = "TEXT")
    private String text;

    /** 销量 */
    private long sales;

    /** 购买后给购买者发送邮件内容 */
    @Column(columnDefinition = "TEXT")
    private String emailText;

    /** 作者删除 */
    private boolean authorDel;

    public Article update(String title, Image cover, String inShort, String text, long integral, String emailText) {
        super.title = title;
        super.integral = integral;
        this.cover = cover;
        this.inShort = inShort;
        this.text = text;
        this.emailText = emailText;
        return this;
    }

    @SuppressWarnings("WeakerAccess")
    public Article(User user) {
        super.user = user;
        this.sales = 0;
    }

    public ArticleDraft publishArticleDraft() {
        ArticleDraft articleDraft = new ArticleDraft(super.getUser());
        return articleDraft.update(super.hobby, super.getTitle(), this.cover, this.inShort, this.text, super.getIntegral(), this.emailText).setHobby(getHobby());
    }

    public Article addText(String addText) {
        this.text += addText;
        return this;
    }

    @Override
    public Article setHobby(Hobby hobby) {
        super.setHobby(hobby);
        return this;
    }

    public Article setCover(Image cover) {
        this.cover = cover;
        return this;
    }

    public Article addSales() {
        ++this.sales;
        return this;
    }

    Article() {
    }

    public long getSales() {
        return sales;
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

    public boolean getAuthorDel() {
        return authorDel;
    }

    public Article setAuthorDel(boolean authorDel) {
        this.authorDel = authorDel;
        return this;
    }

    @Override
    public AppType getAppType() {
        return AppType.ARTICLE;
    }
}
