package com.FIS.OnlineShoppingCart.dev.dao;
import java.util.List;

import com.FIS.OnlineShoppingCart.dev.entities.Blog;

public interface BlogDAO {
    public List<Blog> getAllBlogs();

    public Blog getOneBlog(Integer id);

    public void addNewBlog(Blog blog);

    public void deleteBlog(Blog blog);

    public void editBlog(Blog blog);

    //public List<Blog> getBlogForBlogPage(String keyword, String categoryForBlog, String month, Pageable pageable);
}
