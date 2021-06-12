package com.DXTech.YQDL.service;

import com.DXTech.YQDL.dao.UserDao;
import com.DXTech.YQDL.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByName(String name,String password){
        return userDao.getUserByName(name,password);
    }


}
