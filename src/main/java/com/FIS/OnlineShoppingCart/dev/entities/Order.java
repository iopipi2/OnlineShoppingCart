package com.FIS.OnlineShoppingCart.dev.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class Order {


    @Column(name = "total", precision = 13, scale = 2, nullable = false)
    private BigDecimal total;


    @Id // xác định đây là khoá chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
    @Column(name = "id")
    private Integer id; // primary-key

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name="updated_date", nullable = false)
    private Date updated_date;

    @Column(name="note_by_customer", columnDefinition = "LONGTEXT", nullable = false)
    private String note_by_customer;

    @Column(name="note_by_admin", columnDefinition = "LONGTEXT", nullable = false)
    private String note_by_admin;

    @Column(name="address", columnDefinition = "LONGTEXT")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Column(name = "status")
    private Integer status= 0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderProducts> orderProducts = new ArrayList<OrderProducts>();

    public void addSaleOrderProducts(OrderProducts _saleOrderProducts) {
        _saleOrderProducts.setOrder(this);
        orderProducts.add(_saleOrderProducts);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProducts> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by")
    private Account user;

    public Account getUser() {
        return user;
    }

    public String getNote_by_customer() {
        return note_by_customer;
    }

    public void setNote_by_customer(String note_by_customer) {
        this.note_by_customer = note_by_customer;
    }

    public void setUser(Account user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNote_by_admin() {
        return note_by_admin;
    }

    public void setNote_by_admin(String note_by_admin) {
        this.note_by_admin = note_by_admin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

}