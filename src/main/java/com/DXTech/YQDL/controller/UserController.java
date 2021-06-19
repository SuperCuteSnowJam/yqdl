package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.User;
import com.DXTech.YQDL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUserByName")
    public boolean getUser(@RequestParam("name") String username, @RequestParam("pwd") String password) {
        User user = userService.getUserByName(username, password);
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

}
