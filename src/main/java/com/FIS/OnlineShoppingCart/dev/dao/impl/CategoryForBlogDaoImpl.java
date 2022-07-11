package com.FIS.OnlineShoppingCart.dev.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FIS.OnlineShoppingCart.dev.dao.CategoryForBlogDAO;
import com.FIS.OnlineShoppingCart.dev.entities.CategoriesForBlog;

@Repository
public class CategoryForBlogDaoImpl implements CategoryForBlogDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<CategoriesForBlog> getAllCategoryForBlogs() {
        String jql = "Select c FROM CategoriesForBlog c";
        return entityManager.createQuery(jql, CategoriesForBlog.class).getResultList();
    }

    @Override
    public CategoriesForBlog getOne(int id) {

        return entityManager.find(CategoriesForBlog.class, id);
    }

    @Override
    public void add(CategoriesForBlog categoriesForBlog) {
        entityManager.persist(categoriesForBlog);
    }

    @Override
    public void delete(CategoriesForBlog categoriesForBlog) {
        entityManager.remove(categoriesForBlog);
    }

    @Override
    public void edit(CategoriesForBlog categoriesForBlog) {
        entityManager.merge(categoriesForBlog);
    }


}