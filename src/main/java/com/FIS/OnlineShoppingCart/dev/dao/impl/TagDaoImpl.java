package com.FIS.OnlineShoppingCart.dev.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FIS.OnlineShoppingCart.dev.dao.TagDAO;
import com.FIS.OnlineShoppingCart.dev.entities.Tag;

@Transactional
@Repository
public class TagDaoImpl implements TagDAO{

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Tag> getAllTag() {
        String jql= "SELECT t FROM Tag t";
        return entityManager.createQuery(jql, Tag.class).getResultList();
    }



}
