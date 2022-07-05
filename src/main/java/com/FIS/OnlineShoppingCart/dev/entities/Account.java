package com.FIS.OnlineShoppingCart.dev.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_customer")
public class Account {
    private static final long serialVersionUID = -1956195527415323516L;

    @Id // xác định đây là khoá chính.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
    @Column(name = "id")
    private Integer id; // primary-key


    @Column(name = "status", nullable = false)
    private Boolean status = Boolean.TRUE;

    @Column(name = "username", length = 200, nullable = false)
    private String username;
    @Column(name = "password", length = 200, nullable = false)
    private String password;
    @Column(name = "user_role", length = 200, nullable = false)
    private String user_role;
    @Column(name = "fullname", length = 200, nullable = false)
    private String fullname;

    @Column(name="phone", length = 10, nullable = false)
    private String phone;

    @Column(name="email", length = 200, nullable = false)
    private String email;
    @Column(name="address", length = 1000, nullable = false)
    private String address;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public boolean hasAuthority(String string) {
        // TODO Auto-generated method stub
        return false;
    }


}