package com.FIS.OnlineShoppingCart.dev.model;


import javax.persistence.Transient;

public class ProductDTO {

    private int id;
    private String name;
    private Long price;
    private String description;
    private CategoriesDTO category;
    private String img_main;
    private String img_hover;
    private String img_sub;

    public ProductDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductDTO(int id, String name, Long price, String description, CategoriesDTO category, String img_main,
                      String img_hover, String img_sub) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.img_main = img_main;
        this.img_hover = img_hover;
        this.img_sub = img_sub;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoriesDTO getCategory() {
        return category;
    }

    public void setCategory(CategoriesDTO category) {
        this.category = category;
    }

    public String getImg_main() {
        return img_main;
    }

    public void setImg_main(String img_main) {
        this.img_main = img_main;
    }

    public String getImg_hover() {
        return img_hover;
    }

    public void setImg_hover(String img_hover) {
        this.img_hover = img_hover;
    }

    public String getImg_sub() {
        return img_sub;
    }

    public void setImg_sub(String img_sub) {
        this.img_sub = img_sub;
    }

    @Transient
    public String getMainImagePath() {
        if (img_main == null) return null;

        return "/product-images/" + id + "/" + img_main;
    }

    @Transient
    public String getSubImagePath() {
        if (img_sub == null) return null;

        return "/product-images/" + id + "/" + img_sub;
    }

    @Transient
    public String getHoverImagePath() {
        if (img_hover == null) return null;

        return "/product-images/" + id + "/" + img_hover;
    }
}
