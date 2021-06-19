package com.DXTech.YQDL.controller;

import com.DXTech.YQDL.entity.PowerStationImage;
import com.DXTech.YQDL.service.PowerStationImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class PowerStationImageController {

    @Autowired
    private PowerStationImageService powerStationImageService;

    @PostMapping(value = "/uploadImage")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        if(powerStationImageService.uploadImage(file)){
            return "success";
        }else{
            return "fail";
        }
    }

    @GetMapping(value = "/downloadImage")
    public byte[] downloadImage(){
        return powerStationImageService.downloadImage().getImage_info();
    }

}
