package com.dxtech.yqdl.service;

import com.dxtech.yqdl.dao.PowerStationImageDao;
import com.dxtech.yqdl.entity.PowerStationImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 输入图片名称获取图片实例
     *
     * @param filename 图片名称
     * @return
     */
    public List<PowerStationImage> listImageByFileName(String filename){
        return powerStationImageDao.listImageByFileName(filename);
    }

}
