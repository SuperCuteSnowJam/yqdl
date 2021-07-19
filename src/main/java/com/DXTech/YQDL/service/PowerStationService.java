package com.DXTech.YQDL.service;

import com.DXTech.YQDL.dao.PowerStationDao;
import com.DXTech.YQDL.entity.PowerStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerStationService {

    @Autowired
    private PowerStationDao powerStationDao;

    public List<PowerStation> getStation(){
        return powerStationDao.getStation();
    }

    public List<PowerStation> getStationByName(String name){
        return powerStationDao.getStationByName(name);
    }

    public boolean deleteStationById(String id){
        return powerStationDao.deleteStationById(id);
    }

    public boolean insertStation(String name,String voltage_level,String desc){
        return powerStationDao.insertStation(name,voltage_level,desc);
    }
}
