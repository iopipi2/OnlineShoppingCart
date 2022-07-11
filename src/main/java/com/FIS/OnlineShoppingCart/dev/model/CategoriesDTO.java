package com.FIS.OnlineShoppingCart.dev.model;

public class CategoriesDTO {

    private int id_cate;
    private String type;


    public CategoriesDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CategoriesDTO(int id_cate, String type) {
        super();
        this.id_cate = id_cate;
        this.type = type;
    }

    public int getId_cate() {
        return id_cate;
    }

    public void setId_cate(int id_cate) {
        this.id_cate = id_cate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
