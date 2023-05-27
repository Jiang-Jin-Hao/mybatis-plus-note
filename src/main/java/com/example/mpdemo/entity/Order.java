package com.example.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@TableName("t_order")
public class Order {
    private String id;
//    @DateTimeFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date orderTime;
    private double total;
    private String uid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Order() {
    }

    //该订单有哪些用户
    @TableField(exist = false)
    private User user;

    public Order(String id, Date orderTime, double total, String uid, User user) {
        this.id = id;
        this.orderTime = orderTime;
        this.total = total;
        this.uid = uid;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
