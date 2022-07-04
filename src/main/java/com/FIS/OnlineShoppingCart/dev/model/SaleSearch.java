package com.FIS.OnlineShoppingCart.dev.model;

import java.util.Date;

public class SaleSearch {
    String sale_name;
    int dicount;
    Date start_date;
    Date end_date;
    int status;
    public String getSale_name() {
        return sale_name;
    }
    public void setSale_name(String sale_name) {
        this.sale_name = sale_name;
    }
    public int getDicount() {
        return dicount;
    }
    public void setDicount(int dicount) {
        this.dicount = dicount;
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
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
