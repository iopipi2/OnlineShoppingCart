package com.FIS.OnlineShoppingCart.dev.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FIS.OnlineShoppingCart.dev.dao.BlogDAO;
import com.FIS.OnlineShoppingCart.dev.dao.BlogRepository;
import com.FIS.OnlineShoppingCart.dev.entities.Blog;


@Transactional
@Repository
public class BlogDaoImpl implements BlogDAO {

    @Autowired
    EntityManager enityManger;

    @Autowired
    BlogRepository blogRepo;

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public Blog getOneBlog(Integer id) {
        return blogRepo.getById(id);
    }

    @Override
    public void addNewBlog(Blog blog) {
        enityManger.persist(blog);
    }

    @Override
    public void deleteBlog(Blog blog) {
        enityManger.remove(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        enityManger.merge(blog);
    }

    /*
     * @Override public List<Blog> getBlogForBlogPage(String keyword, String
     * categoryForBlog, String month, Pageable pageable) {
     *
     * return blogRepo.findAll(keyword, categoryForBlog, month, pageable); }
     */
}
