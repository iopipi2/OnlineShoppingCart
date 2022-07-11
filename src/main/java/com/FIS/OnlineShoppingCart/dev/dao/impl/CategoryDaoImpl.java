package com.FIS.OnlineShoppingCart.dev.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.FIS.OnlineShoppingCart.dev.dao.CategoryDAO;
import com.FIS.OnlineShoppingCart.dev.entities.Categories;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Categories> getAll() {
        String jql = "Select c FROM Categories c";
        return entityManager.createQuery(jql, Categories.class).getResultList();
    }

}
