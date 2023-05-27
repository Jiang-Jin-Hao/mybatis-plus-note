package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.Order;
import com.example.mpdemo.entity.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from t_order where uid=#{id}")
    public Order selectById();

    //查询订单及其所有的用户
    @Select("select * from t_order")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "order_time", property = "orderTime"),
            @Result(column = "total", property = "total"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "uid", property = "user", javaType = User.class
                    , one = @One(select = "com.example.mpdemo.mapper.UserMapper.selectById"))
    })
    List<Order> selectAllOrderAndUsers();
}
