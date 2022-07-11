package com.FIS.OnlineShoppingCart.dev.model;


public class CouponDTO {

    private int id;
    private String code;
    private double discount;

    public CouponDTO() {

    }

    public CouponDTO(int id, String code, double discount) {
        super();
        this.id = id;
        this.code = code;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }


}