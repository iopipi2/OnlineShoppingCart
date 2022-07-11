package com.FIS.OnlineShoppingCart.dev.dao.impl;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FIS.OnlineShoppingCart.dev.dao.CounponDAO;
import com.FIS.OnlineShoppingCart.dev.entities.Coupon;

@Transactional
@Repository
public class CouponDaoImpl implements CounponDAO {

    @Autowired
    EntityManager EntityManager;

    @Override
    public Coupon findCouponByCode(String code) {
        String jql = "SELECT c FROM Coupon c WHERE c.code = :code";
        return EntityManager.createQuery(jql, Coupon.class).setParameter("code", code).getSingleResult();
    }

}