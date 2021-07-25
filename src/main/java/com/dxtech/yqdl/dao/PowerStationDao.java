package com.dxtech.yqdl.dao;

import com.dxtech.yqdl.entity.PowerStation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PowerStationDao {

    @Select("select * from power_station")
    List<PowerStation> getStation();

    @Select("select * from power_station where name like '%${name}%'")
    List<PowerStation> getStationByName(@Param("name") String name);

    @Delete("delete from power_station where id = #{id}")
    boolean deleteStationById(@Param("id") String id);

    @Insert("insert into power_station values(null,#{name},#{voltage_level},#{desc})")
    boolean insertStation(@Param("name") String name,@Param("voltage_level") String voltage_level,@Param("desc") String desc);
}
