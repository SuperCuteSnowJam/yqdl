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

    @GetMapping("/getStationByName")
    public String getStationByName(@RequestParam("name") String name, ModelMap map) {
        List<PowerStation> psList = powerStationService.getStationByName(name);
        map.addAttribute("psList",psList);
        List<PowerStationImage> psiList = powerStationImageService.getStationImage();
        map.addAttribute("psiList",psiList);
        return "manage_core";
    }

    @GetMapping("/deleteStationById")
    public String deleteStationById(@RequestParam("id") String id, ModelMap map) {
        powerStationService.deleteStationById(id);
        List<PowerStation> psList = powerStationService.getStation();
        map.addAttribute("psList",psList);
        List<PowerStationImage> psiList = powerStationImageService.getStationImage();
        map.addAttribute("psiList",psiList);
        return "manage_core";
    }

    @GetMapping("/insertStation")
    public String insertStation(@RequestParam("name") String name,@RequestParam("voltage_level") String voltage_level,@RequestParam("desc") String desc, ModelMap map) {
        powerStationService.insertStation(name,voltage_level,desc);
        List<PowerStation> psList = powerStationService.getStation();
        map.addAttribute("psList",psList);
        List<PowerStationImage> psiList = powerStationImageService.getStationImage();
        map.addAttribute("psiList",psiList);
        return "manage_core";
    }

}
