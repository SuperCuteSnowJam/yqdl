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

}
