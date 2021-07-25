package com.dxtech.yqdl.controller;

import com.dxtech.yqdl.entity.PowerStation;
import com.dxtech.yqdl.entity.PowerStationImage;
import com.dxtech.yqdl.service.PowerStationImageService;
import com.dxtech.yqdl.service.PowerStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

    @GetMapping("/queryFile")
    public String queryFile(ModelMap map,@RequestParam("imageName") String imageName){

        List<PowerStation> psList = powerStationService.getStation();
        map.addAttribute("psList",psList);

        List<PowerStationImage> psiList = null;
        if("".equals(imageName)){
            psiList =  powerStationImageService.getStationImage();
        }else{
            psiList = powerStationImageService.listImageByFileName(imageName);
        }
        map.addAttribute("psiList",psiList);

        map.addAttribute("sheetheader","");
        map.addAttribute("sheetheader2","active");
        map.addAttribute("sheetheader3","");
        map.addAttribute("sheetheader4","");
        map.addAttribute("sheet","tab-pane");
        map.addAttribute("sheet2","tab-pane active");
        map.addAttribute("sheet3","tab-pane");
        map.addAttribute("sheet4","tab-pane");
        return "manage_core";
    }

    @GetMapping("/test")
    public String test() {return "test";}
}
