package com.FIS.OnlineShoppingCart.dev.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FIS.OnlineShoppingCart.dev.dao.CategoryForBlogDAO;
import com.FIS.OnlineShoppingCart.dev.entities.CategoriesForBlog;
import com.FIS.OnlineShoppingCart.dev.model.CategoriesForBlogDTO;
import com.FIS.OnlineShoppingCart.dev.service.CategoryForBlogService;

@Transactional
@Service
public class CategotyForBlogServiceImpl implements CategoryForBlogService {

    @Autowired
    CategoryForBlogDAO categoryForBlogDao;

    @Override
    public List<CategoriesForBlogDTO> getAllCategoryForBlog() {

        List<CategoriesForBlog> list = categoryForBlogDao.getAllCategoryForBlogs();

        List<CategoriesForBlogDTO> listCategoriesForBlogDTO = new ArrayList<>();

        for(CategoriesForBlog c : list) {

            CategoriesForBlogDTO categoriesForBlogDTO = new CategoriesForBlogDTO();

            categoriesForBlogDTO.setId(c.getId());
            categoriesForBlogDTO.setType(c.getType());

            listCategoriesForBlogDTO.add(categoriesForBlogDTO);

        }

        return listCategoriesForBlogDTO ;
    }

    @Override
    public CategoriesForBlogDTO getOne(int id) {

        CategoriesForBlog c = categoryForBlogDao.getOne(id);

        CategoriesForBlogDTO categoriesForBlogDTO = new CategoriesForBlogDTO();

        categoriesForBlogDTO.setId(c.getId());
        categoriesForBlogDTO.setType(c.getType());

        return categoriesForBlogDTO;
    }

    @Override
    public void add(CategoriesForBlogDTO catgoriesForBlogDTO) {

        CategoriesForBlog categoriesForBlog = new CategoriesForBlog();

        categoriesForBlog.setId(catgoriesForBlogDTO.getId());
        categoriesForBlog.setType(catgoriesForBlogDTO.getType());

        categoryForBlogDao.add(categoriesForBlog);

    }

    @Override
    public void delete(int id) {

        CategoriesForBlog c = categoryForBlogDao.getOne(id);

        if(c != null) {
            categoryForBlogDao.delete(c);
        }

    }

    @Override
    public void edit(CategoriesForBlogDTO categoriesForBlogDTO) {

        CategoriesForBlog categoriesForBlog = categoryForBlogDao.getOne(categoriesForBlogDTO.getId());

        //System.out.println(categoriesForBlogDTO.getId());

        if(categoriesForBlog != null) {
            categoriesForBlog.setId(categoriesForBlogDTO.getId());
            categoriesForBlog.setType(categoriesForBlogDTO.getType());
        }

        categoryForBlogDao.edit(categoriesForBlog);


    }

}