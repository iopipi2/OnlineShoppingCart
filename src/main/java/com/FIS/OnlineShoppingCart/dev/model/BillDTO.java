package com.FIS.OnlineShoppingCart.dev.model;


public class BillDTO {
    private Long id;
    private UserDTO user;
    private String buyDate;
    private Long priceTotal;
    private Integer discountPercent;
    private String status;
    private String pay;



    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public Long getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Long d) {
        this.priceTotal = d;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }


}
