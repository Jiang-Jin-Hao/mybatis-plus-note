package com.example.mpdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /*@GetMapping("/user")
    public List<User> queryAll() {
        return userMapper.getAll();
    }*/

    @GetMapping("/user")
    public List<User> queryAll() {
        return userMapper.selectList(null);
    }

    /*@PostMapping("/user")
    public int insertUser(User user) {
        return userMapper.add(user);
    }*/

    @GetMapping("/user/findAll")
    public List<User> findAll() {
        return userMapper.selectAllUserAndOrders();
    }

    @GetMapping("/user/find/{username}")
    public List<User> findByCond(@PathVariable("username") String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.like("username", "%" + username + "%");
        return userMapper.selectList(queryWrapper);
    }

    @GetMapping("/user/findByPage/{current}/{size}")
    public IPage findByPage(@PathVariable("current") int current, @PathVariable("size") int size) {

        Page<User> page = new Page<>(current, size);

        return userMapper.selectPage(page, null);
    }

}
