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
}
