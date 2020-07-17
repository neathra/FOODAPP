package com.example.fooddeliveryapp;

import java.io.Serializable;

public class OrderModel implements Serializable {

    String currentStatus,description,foodname,price,qty,totalPrice;

    public OrderModel(String currentStatus, String description, String foodname, String price, String qty, String totalPrice) {
        this.currentStatus = currentStatus;
        this.description = description;
        this.foodname = foodname;
        this.price = price;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }

    public OrderModel() {
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
