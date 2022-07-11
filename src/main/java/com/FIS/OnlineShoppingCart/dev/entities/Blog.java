package com.FIS.OnlineShoppingCart.dev.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "image")
    public String imageBlog;

    @Column(name = "created_time", updatable = false)
    private String created_time;

    @Column(name = "created_month", updatable = false)
    private String created_month;

    @Column(name = "created_day", updatable = false)
    private int created_day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoriesForBlog categoriesForBlog;

    //many to many dung dung casecade nha. vi no se luu auto theo roi.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "blog_tag", joinColumns = @JoinColumn(name = "blog_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<Tag>();

    public Blog() {
    }

    public Blog(String title, String content, String created_time) {
        this.title = title;
        this.content = content;
        this.created_time = created_time;
    }

    public Blog(Integer id, String title, String content, String created_time, String created_month, int created_day,
                CategoriesForBlog categoriesForBlog, Set<Tag> tags, String imageBlog) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageBlog = imageBlog;
        this.created_time = created_time;
        this.created_month = created_month;
        this.created_day = created_day;
        this.categoriesForBlog = categoriesForBlog;
        this.tags = tags;
    }

    public Blog(Integer id2) {
        this.id = id2;
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

    public CategoriesForBlog getCategoriesForBlog() {
        return categoriesForBlog;
    }

    public void setCategoriesForBlog(CategoriesForBlog categoriesForBlog) {
        this.categoriesForBlog = categoriesForBlog;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getCreated_month() {
        return created_month;
    }

    public void setCreated_month(String created_month) {
        this.created_month = created_month;
    }

    public int getCreated_day() {
        return created_day;
    }

    public void setCreated_day(int created_day) {
        this.created_day = created_day;
    }

    @Transient
    public String getBlogImagePath() {
        if (imageBlog == null)
            return null;

        return "/blog-images/" + id + "/" + imageBlog;
    }

}
