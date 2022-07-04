package com.FIS.OnlineShoppingCart.dev.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_image")
public class Images {
    @Id // xác định đây là khoá chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
    @Column(name = "id")
    private Integer id; // primary-key

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "path", nullable = false)
    private String path;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id") // tên field khoá ngoại
    private Product product;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gift_id") // tên field khoá ngoại
    private Gift giftI;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "news_id") // tên field khoá ngoại
    private News news;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Gift getGift() {
        return giftI;
    }
    public void setGift(Gift gift) {
        this.giftI = gift;
    }
    public News getNews() {
        return news;
    }
    public void setNews(News news) {
        this.news = news;
    }



}