package com.DXTech.YQDL.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("qwe")
    public String getUser() {
        return "getUser";
    }
}
