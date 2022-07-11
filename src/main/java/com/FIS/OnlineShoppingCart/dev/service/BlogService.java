package com.FIS.OnlineShoppingCart.dev.service;


import java.util.List;

import com.FIS.OnlineShoppingCart.dev.entities.Blog;
import com.FIS.OnlineShoppingCart.dev.model.BlogDTO;

public interface BlogService {

    public List<BlogDTO> getAllBlogs();

    public BlogDTO getOneBlog(Integer id);

    public Blog addNewBlog(BlogDTO blogDTO);

    public Blog editBlog(BlogDTO blogDTO);

    public void deleteBlog(int id);

    public List<BlogDTO> getBlogForBlogPage(String keyword, String category, String month, String tag,  int page, int sizePerPage);

    public long count();
}
