package com.FIS.OnlineShoppingCart.dev.model;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

public class ProductSearch {


    private String seoProduct;
    private String seoCategoty;
    private String name;
    private Integer id;
    private Integer categoryId;

    public Integer offset = null;
    public Integer count = null;

    public String searchText;

    public void buildPaging(HttpServletRequest request) {
        if (!StringUtils.isEmpty(request.getParameter("offset"))) {
            this.offset = Integer.parseInt(request.getParameter("offset"));
        } else {
            this.offset = 0;
        }
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getSeoProduct() {
        return seoProduct;
    }

    public void setSeoProduct(String seoProduct) {
        this.seoProduct = seoProduct;
    }

    public String getSeoCategoty() {
        return seoCategoty;
    }

    public void setSeoCategoty(String seoCategoty) {
        this.seoCategoty = seoCategoty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }


}