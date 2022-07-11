package com.FIS.OnlineShoppingCart.dev.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FIS.OnlineShoppingCart.dev.dao.CounponDAO;
import com.FIS.OnlineShoppingCart.dev.entities.Coupon;
import com.FIS.OnlineShoppingCart.dev.model.CouponDTO;
import com.FIS.OnlineShoppingCart.dev.service.CouponService;

@Repository
@Transactional
public class CouponServiceImpl implements CouponService {

    @Autowired
    CounponDAO couponDAO;

    @Override
    public CouponDTO findCouponByCode(String code) {

        Coupon couponEntity = couponDAO.findCouponByCode(code);

        CouponDTO couponDTO = new CouponDTO();

        couponDTO.setId(couponEntity.getId());
        couponDTO.setCode(couponEntity.getCode());
        couponDTO.setDiscount(couponEntity.getDiscount());

        return couponDTO;
    }


}