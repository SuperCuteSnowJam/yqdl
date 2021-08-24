package com.dxtech.yqdl.controller;

import com.dxtech.yqdl.entity.User;
import com.dxtech.yqdl.service.UserService;
import com.dxtech.yqdl.utils.ResponseInfo;
import com.dxtech.yqdl.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getUserByName")
    public boolean getUser(@RequestParam("name") String username, @RequestParam("pwd") String password, HttpSession httpsession) {
        User user = userService.getUserByName(username, password);
        if (user != null) {
            httpsession.setAttribute("loginuser",username);
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/getUserByNameByDownload")
    public ResponseInfo getUser2(@RequestParam("name") String username, @RequestParam("pwd") String password, HttpSession httpsession) {
        User user = userService.getUserByName(username, password);
        if (user != null) {
            return ResponseUtil.success("");
        } else {
            return ResponseUtil.fail("");
        }
    }

}
