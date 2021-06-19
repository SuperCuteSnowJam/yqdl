package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.PowerStation;
import com.DXTech.YQDL.entity.PowerStationImage;
import com.DXTech.YQDL.service.PowerStationImageService;
import com.DXTech.YQDL.service.PowerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/admin")
    public String admin(ModelMap map) {
        List<PowerStation> psList = powerStationService.getStation();
        map.addAttribute("psList",psList);

        List<PowerStationImage> psiList = powerStationImageService.getStationImage();
        map.addAttribute("psiList",psiList);
        return "admin";
    }

    @GetMapping("/test")
    public String test() {return "test";}
}
