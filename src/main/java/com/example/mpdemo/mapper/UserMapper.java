package com.example.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mpdemo.entity.Order;
import com.example.mpdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /*@Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    int add(User user);

    @Update("update user set username=#{username},password=#{password},birthday=#{birthday} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id=#{id}")
    int delete(int id);

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user")
    List<User> getAll();*/

    //查询用户及其所有的订单
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "id", property = "orders", javaType = List.class
                    , many = @Many(select = "com.example.mpdemo.mapper.OrderMapper.selectById"))
    })
    List<User> selectAllUserAndOrders();

    @Select("select * from user where id=#{uid}")
    public User selectById();

}
