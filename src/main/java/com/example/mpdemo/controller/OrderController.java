package com.example.mpdemo.controller;

import com.example.mpdemo.entity.Order;
import com.example.mpdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public OrderMapper orderMapper;

    @GetMapping("/findAll")
    public List<Order> findAll(){
        return orderMapper.selectAllOrderAndUsers();
    }

}
