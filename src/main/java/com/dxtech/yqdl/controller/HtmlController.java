package com.dxtech.yqdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping({"/station"})
    public String getStation() {
        return "station";
    }

    @GetMapping({"/device"})
    public String getDevice() {
        return "device";
    }

    @GetMapping({"/cellwall"})
    public String getCellwall() {
        return "cellwall";
    }

    @GetMapping({"/resource"})
    public String getResource() {
        return "resource";
    }

}
