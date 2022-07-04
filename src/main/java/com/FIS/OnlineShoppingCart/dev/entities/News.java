package com.FIS.OnlineShoppingCart.dev.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_news")
public class News extends BaseEntity{
    @Column(name = "title", nullable = true, columnDefinition = "LONGTEXT")
    private String title;

    @Lob
    @Column(name="short_news", nullable = true, columnDefinition = "LONGTEXT")
    private String short_news;

    @Lob
    @Column(name="news_detail", nullable = true, columnDefinition = "LONGTEXT")
    private String news_detail;

    @Column(name="seo", nullable = true)
    private String seo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "news", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Images> newsImages = new ArrayList<Images>();

    public void addNewsImages(Images _newsImages) {
        _newsImages.setNews(this);
        newsImages.add(_newsImages);
    }

    public void removeNewsImages(Images _newsImages) {
        _newsImages.setNews(null);
        newsImages.remove(_newsImages);
    }

    public void removeNewsImages() {
        for(Images newsImages : newsImages) {
            removeNewsImages(newsImages);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShort_name() {
        return short_news;
    }

    public void setShort_name(String short_news) {
        this.short_news = short_news;
    }

    public String getNews_detail() {
        return news_detail;
    }

    public void setNews_detail(String news_detail) {
        this.news_detail = news_detail;
    }

    public String getShort_news() {
        return short_news;
    }

    public void setShort_news(String short_news) {
        this.short_news = short_news;
    }

    public String getSeo() {
        return seo;
    }

    public void setSeo(String seo) {
        this.seo = seo;
    }

    public List<Images> getNewsImages() {
        return newsImages;
    }

    public void setNewsImages(List<Images> newsImages) {
        this.newsImages = newsImages;
    }


}