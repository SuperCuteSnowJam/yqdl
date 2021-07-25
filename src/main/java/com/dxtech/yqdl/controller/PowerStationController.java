package com.dxtech.yqdl.controller;

import com.dxtech.yqdl.entity.PowerStation;
import com.dxtech.yqdl.entity.PowerStationImage;
import com.dxtech.yqdl.service.PowerStationImageService;
import com.dxtech.yqdl.service.PowerStationService;
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
    public String getStationByName(ModelMap map,@RequestParam("name") String name) {
        List<PowerStation> psList = powerStationService.getStationByName(name);
        map.addAttribute("psList",psList);
        List<PowerStationImage> psiList = powerStationImageService.getStationImage();
        map.addAttribute("psiList",psiList);
        map.addAttribute("sheetheader","active");
        map.addAttribute("sheetheader2","");
        map.addAttribute("sheetheader3","");
        map.addAttribute("sheetheader4","");
        map.addAttribute("sheet","tab-pane active");
        map.addAttribute("sheet2","tab-pane");
        map.addAttribute("sheet3","tab-pane");
        map.addAttribute("sheet4","tab-pane");
        return "manage_core";
    }

    @GetMapping("/deleteStationById")
    public String deleteStationById(@RequestParam("id") String id) {
        powerStationService.deleteStationById(id);
        return "redirect:/manage_core";
    }

    @GetMapping("/insertStation")
    public String insertStation(@RequestParam("name") String name,@RequestParam("voltage_level") String voltage_level,@RequestParam("desc") String desc) {
        powerStationService.insertStation(name,voltage_level,desc);
        return "redirect:/manage_core";
    }

}
