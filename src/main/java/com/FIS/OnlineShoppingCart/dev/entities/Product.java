package com.FIS.OnlineShoppingCart.dev.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name ="description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id")
    private Categories category;

    @Column(name = "img_main")
    private String img_main;

    @Column(name = "img_hover")
    private String img_hover;

    @Column(name = "img_sub")
    private String img_sub;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Review> review;

    public Product() {
    }

    public Product(int id, String name, Long price, String description, Categories category,
                   String img_main, String img_hover, String img_sub) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.img_main = img_main;
        this.img_hover = img_hover;
        this.img_sub = img_sub;
    }

    public Product(int id) {
        this.id= id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getImg_main() {
        return img_main;
    }

    public void setImg_main(String img_main) {
        this.img_main = img_main;
    }

    public String getImg_hover() {
        return img_hover;
    }

    public void setImg_hover(String img_hover) {
        this.img_hover = img_hover;
    }

    public String getImg_sub() {
        return img_sub;
    }

    public void setImg_sub(String img_sub) {
        this.img_sub = img_sub;
    }

    @Transient
    public String getMainImagePath() {
        if (img_main == null) return null;

        return "/product-images/" + id + "/" + img_main;
    }

    @Transient
    public String getSubImagePath() {
        if (img_sub == null) return null;

        return "/product-images/" + id + "/" + img_sub;
    }

    @Transient
    public String getHoverImagePath() {
        if (img_hover == null) return null;

        return "/product-images/" + id + "/" + img_hover;
    }
}
