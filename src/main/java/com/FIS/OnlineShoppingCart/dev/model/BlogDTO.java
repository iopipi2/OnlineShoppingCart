package com.FIS.OnlineShoppingCart.dev.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

public class BlogDTO {

    private Integer id;

    private String title;

    private String content;

    private String created_time;

    private String imageBlog;

    private String created_month;

    private int created_day;

    private CategoriesForBlogDTO categoriesForBlogDTO;

    private List<TagDTO> tags = new ArrayList<TagDTO>(); ///cho nay em map vao giao dien ko duoc em nhe.
    /// o giao dien no la so id, con cai nay la object em ak//fix nhu nao the a
    //cach 2 don gian hon.
    // tao 1 set int luu id cua tag thoi
    private Set<Integer> tagIds = new HashSet<>();

    public BlogDTO() {
    }

    public BlogDTO(String title, String content, String created_time) {
        this.title = title;
        this.content = content;
        this.created_time = created_time;
    }

    public Set<Integer> getTagIds() {
        return tagIds;
    }

    public void setTagIds(Set<Integer> tagIds) {
        this.tagIds = tagIds;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public void setCreated_month(String created_month) {
        this.created_month = created_month;
    }

    public void setCreated_day(int created_day) {
        this.created_day = created_day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageBlog() {
        return imageBlog;
    }

    public void setImageBlog(String imageBlog) {
        this.imageBlog = imageBlog;
    }

    public CategoriesForBlogDTO getCategoriesForBlogDTO() {
        return categoriesForBlogDTO;
    }

    public void setCategoriesForBlogDTO(CategoriesForBlogDTO categoriesForBlogDTO) {
        this.categoriesForBlogDTO = categoriesForBlogDTO;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;//set ko co index
    }

    public String getCreated_time() {
        return created_time;
    }

    public String getCreated_month() {
        return created_month;
    }

    public int getCreated_day() {
        return created_day;
    }

    @Transient
    public String getBlogImagePath() {
        if (imageBlog == null) return null;

        return "/blog-images/" + id + "/" + imageBlog;
    }
}
