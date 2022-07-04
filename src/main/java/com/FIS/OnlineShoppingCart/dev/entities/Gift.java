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

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigDecimal;
@Entity
@Table(name = "tbl_gift")
public class Gift extends BaseEntity{
    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "price", precision = 13, scale = 2, nullable = false)
    private BigDecimal price;

    @Lob
    @Column(name = "description",columnDefinition = "LONGTEXT", nullable = true)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gift", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> product = new ArrayList<Product>();

    public void addProduct(Product _product) {
        _product.setGift(this);
        product.add(_product);
    }

    public void removeProduct(Product _product) {
        _product.setGift(null);
        product.remove(_product);
    }

    public void removePrduct() {
        for(Product _product : product) {
            removeProduct(_product);
        }
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "giftI", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Images> giftImages = new ArrayList<Images>();

    public void addGiftImages(Images _giftImages) {
        _giftImages.setGift(this);
        giftImages.add(_giftImages);
    }

    public void removeGiftImages(Images _giftImages) {
        _giftImages.setGift(null);
        giftImages.remove(_giftImages);
    }

    public void removeGiftImages() {
        for(Images giftImages : giftImages) {
            removeGiftImages(giftImages);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Images> getGiftImages() {
        return giftImages;
    }

    public void setGiftImages(List<Images> giftImages) {
        this.giftImages = giftImages;
    }

}