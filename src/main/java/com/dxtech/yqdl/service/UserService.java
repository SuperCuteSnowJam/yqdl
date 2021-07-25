package com.dxtech.yqdl.service;

import com.dxtech.yqdl.dao.UserDao;
import com.dxtech.yqdl.entity.User;
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
