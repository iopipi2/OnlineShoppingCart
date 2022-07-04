package com.FIS.OnlineShoppingCart.dev.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "tbl_customer")
public class Customer {
    private static final long serialVersionUID = -1956195527415323516L;

    @Id // xác định đây là khoá chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
    @Column(name = "id")
    private Integer id; // primary-key


    @Column(name = "status", nullable = false)
    private Boolean status = Boolean.TRUE;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name="phone", length = 45, nullable = false)
    private String phone;

    @Column(name="address", length = 1000, nullable = false)
    private String address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> saleOrders = new ArrayList<Order>();

    public void addSaleOrder(Order _saleOrder) {
        _saleOrder.setUser(this);
        saleOrders.add(_saleOrder);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Order> getSaleOrders() {
        return saleOrders;
    }

    public void setSaleOrders(List<Order> saleOrders) {
        this.saleOrders = saleOrders;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public boolean hasAuthority(String string) {
        // TODO Auto-generated method stub
        return false;
    }

}