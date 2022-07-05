package com.FIS.OnlineShoppingCart.dev.model;

import java.math.BigDecimal;

public class ProductInCart {
    private int productId;
    private String tenSP;
    private int soluong;
    private BigDecimal giaBan;
    private BigDecimal tongGia;
    private int amount;
    private String seo;



    public String getSeo() {
        return seo;
    }
    public void setSeo(String seo) {
        this.seo = seo;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getTenSP() {
        return tenSP;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public int getSoluong() {
        return soluong;
    }
    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public BigDecimal getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }
    public BigDecimal getTongGia() {
        return tongGia;
    }
    public void setTongGia(BigDecimal tongGia) {
        this.tongGia = tongGia;
    }



}