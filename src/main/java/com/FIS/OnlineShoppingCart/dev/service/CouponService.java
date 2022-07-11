package com.FIS.OnlineShoppingCart.dev.service;

import com.FIS.OnlineShoppingCart.dev.model.CouponDTO;

public interface CouponService {

    public CouponDTO findCouponByCode(String code);

}
