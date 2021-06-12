package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.User;
import com.DXTech.YQDL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUserByName")
    public boolean getUser(@RequestParam("name") String username, @RequestParam("pwd") String password){
        User user = userService.getUserByName(username,password);
        if(user != null){
            return true;
        }else{
            return false;
        }
    }
}
