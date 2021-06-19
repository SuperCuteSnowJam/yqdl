package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.PowerStation;
import com.DXTech.YQDL.entity.PowerStationImage;
import com.DXTech.YQDL.service.PowerStationImageService;
import com.DXTech.YQDL.service.PowerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PowerStationController {

    @Autowired
    private PowerStationService powerStationService;

    @Autowired
    private PowerStationImageService powerStationImageService;

    @GetMapping("/getStationImageByStationName")
    public String getStationImageByStationName(@RequestParam("stationName") String stationName, ModelMap map) {
        List<PowerStation> psList = powerStationService.getStation();
        map.addAttribute("psList",psList);

        List<PowerStationImage> psiList = powerStationImageService.getStationImageByStationName(stationName);
        map.addAttribute("psiList",psiList);
        return "admin";
    }

}
