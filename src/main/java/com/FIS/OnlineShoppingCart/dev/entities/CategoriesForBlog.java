package com.FIS.OnlineShoppingCart.dev.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories_blog")
public class CategoriesForBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="type")
    private String type;

    /*
     * @OneToMany(mappedBy = "categoriesForBlog") private List<Blog> blogs = new
     * ArrayList<>();
     */

    public CategoriesForBlog() {
    }

    public CategoriesForBlog(int id, String type) {
        super();
        this.id = id;
        this.type = type;
        //this.blogs = blogs;
    }

    public CategoriesForBlog(int id) {
        this.id = id;
    }

    public CategoriesForBlog(String type2) {
        this.type = type2;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /*
     * public List<Blog> getBlogs() { return blogs; }
     *
     * public void setBlogs(List<Blog> blogs) { this.blogs = blogs; }
     */
}