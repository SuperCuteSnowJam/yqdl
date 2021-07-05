package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.PowerStation;
import com.DXTech.YQDL.entity.PowerStationImage;
import com.DXTech.YQDL.service.PowerStationImageService;
import com.DXTech.YQDL.service.PowerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoorController {

    @Autowired
    private PowerStationService powerStationService;

    @Autowired
    private PowerStationImageService powerStationImageService;

    @GetMapping({"/login","/"})
    public String login() {
        return "login";
    }

    @GetMapping("/manage_core")
    public String admin(ModelMap map) {
        List<PowerStation> psList = powerStationService.getStation();
        map.addAttribute("psList",psList);

        List<PowerStationImage> psiList = powerStationImageService.getStationImage();
        map.addAttribute("psiList",psiList);
        return "manage_core";
    }

    @GetMapping("/test")
    public String test() {return "test";}
}
