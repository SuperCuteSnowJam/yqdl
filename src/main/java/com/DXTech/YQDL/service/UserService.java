package com.DXTech.YQDL.service;

import com.DXTech.YQDL.dao.UserDao;
import com.DXTech.YQDL.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

    @Autowired
    private UserDao userDao;

    public User queryUser(int id){
        return userDao.getUserById(id);
    }


}
