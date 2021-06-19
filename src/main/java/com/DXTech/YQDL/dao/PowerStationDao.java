package com.DXTech.YQDL.dao;

import com.DXTech.YQDL.entity.PowerStation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PowerStationDao {

    @Select("select * from power_station")
    List<PowerStation> getStation();
}
