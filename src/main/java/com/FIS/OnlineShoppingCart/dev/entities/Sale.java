package com.FIS.OnlineShoppingCart.dev.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tbl_sale")
public class Sale extends BaseEntity{


    @Column(name = "sale_name",length = 4500, nullable = false)
    private String sale_name ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date", nullable = false)
    private Date start_date ;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date", nullable = false)
    private Date end_date ;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sale")
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getSale_name() {
        return sale_name;
    }

    public void setSale_name(String sale_name) {
        this.sale_name = sale_name;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}