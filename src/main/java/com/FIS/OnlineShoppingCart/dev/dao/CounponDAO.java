package com.FIS.OnlineShoppingCart.dev.dao;
import com.FIS.OnlineShoppingCart.dev.entities.Coupon;

public interface CounponDAO {

    public Coupon findCouponByCode(String code);

}
