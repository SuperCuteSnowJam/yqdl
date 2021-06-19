package com.DXTech.YQDL.service;

import com.DXTech.YQDL.dao.PowerStationImageDao;
import com.DXTech.YQDL.entity.PowerStationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class PowerStationImageService {

    @Autowired
    private PowerStationImageDao powerStationImageDao;

    public List<PowerStationImage> getStationImage(){
        return powerStationImageDao.getStationImage();
    }

    public List<PowerStationImage> getStationImageByStationName(String name){
        return powerStationImageDao.getStationImageByStationName(name);
    }

    public boolean uploadImage(MultipartFile file){
        System.out.println("上传文件的名称是" + file.getName());
        try{
        PowerStationImage psi = new PowerStationImage();
        psi.setImage_name(file.getName());
        psi.setImage_desc("----");
        psi.setPower_station_name("长岭站");
        psi.setImage_info(file.getBytes());
        powerStationImageDao.insertImage(psi);
    }catch (Exception e){
        e.printStackTrace();
    }
        return true;
    }

    public PowerStationImage downloadImage(){
        return powerStationImageDao.downloadImage();
    }
}
