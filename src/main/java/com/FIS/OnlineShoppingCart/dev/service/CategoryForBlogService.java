package com.FIS.OnlineShoppingCart.dev.service;

import java.util.List;

import com.FIS.OnlineShoppingCart.dev.model.CategoriesForBlogDTO;

public interface CategoryForBlogService  {

    public List<CategoriesForBlogDTO> getAllCategoryForBlog();

    public CategoriesForBlogDTO getOne(int id);

    public void add(CategoriesForBlogDTO catgoriesForBlogDTO);

    public void delete(int id);

    public void edit(CategoriesForBlogDTO categoriesForBlogDTO);

}
