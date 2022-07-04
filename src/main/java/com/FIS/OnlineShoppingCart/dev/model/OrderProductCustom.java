package com.FIS.OnlineShoppingCart.dev.model;

import java.math.BigDecimal;

import com.FIS.OnlineShoppingCart.dev.entities.OrderProducts;


public class OrderProductCustom {
    private OrderProducts orderProduct;
    private BigDecimal thanhTien;
    public OrderProducts getOrderProduct() {
        return orderProduct;
    }
    public void setOrderProduct(OrderProducts orderProduct) {
        this.orderProduct = orderProduct;
    }
    public BigDecimal getThanhTien() {
        return thanhTien;
    }
    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

}