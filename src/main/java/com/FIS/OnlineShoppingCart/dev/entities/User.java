package com.FIS.OnlineShoppingCart.dev.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user", schema = "commerce")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name ="password")
    private String password;

    @Column(name ="mail")
    private String username;

    @Column(name ="role")
    private String role;

    @Column(name="enabled")
    private Boolean enabled;

    @Column(name = "created_time", updatable = false)
    private Date created_time;

    @Column(name ="name")
    private String name;

    private String phone;

    private String city;
    private String address;
    private String state;
    private int country_id;
    private String postal_code;
    private String avatar;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
    private AuthenticationProvider authProvider;

    @Column(name = "one_time_password")
    private String oneTimePassword;

    @Column(name = "otp_requested_time")
    private Date otpRequestedTime;

    public User(int id, String password, String username, String role, Boolean enabled, Date created_time, String name,
                String phone, String city, String address, String state, int country_id, String postal_code,String avatar,
                AuthenticationProvider authProvider) {
        super();
        this.id = id;
        this.password = password;
        this.username = username;
        this.role = role;
        this.enabled = enabled;
        this.created_time = created_time;
        this.name = name;
        this.phone = phone;
        this.city = city;
        this.address = address;
        this.state = state;
        this.country_id = country_id;
        this.postal_code = postal_code;
        this.avatar = avatar;
        this.authProvider = authProvider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public AuthenticationProvider getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(AuthenticationProvider authProvider) {
        this.authProvider = authProvider;
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    public Date getOtpRequestedTime() {
        return otpRequestedTime;
    }

    public void setOtpRequestedTime(Date otpRequestedTime) {
        this.otpRequestedTime = otpRequestedTime;
    }

    @Transient
    public String getAvatarImagePath() {
        if (avatar == null) return null;

        return "/avatar-images/" + id + "/" + avatar;
    }

    public boolean isOTPRequired(){
        if(this.oneTimePassword == null){
            return false;
        }

        long otpRequestedTimeMillis = this.otpRequestedTime.getTime();

        if(otpRequestedTimeMillis + OTP_VALID_DURATION < System.currentTimeMillis()){ //Thời gian request + 5 phút nhỏ hơn thời gian hiện tại => hết hiệu lực mã OTP
            return false; //OTP hết hạn
        }
        return true;
    }

    private static final long OTP_VALID_DURATION = 5 * 60 * 1000; // 5 phút
}