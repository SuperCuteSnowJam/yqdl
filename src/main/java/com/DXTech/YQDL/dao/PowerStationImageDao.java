package com.DXTech.YQDL.dao;

import com.DXTech.YQDL.entity.PowerStationImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PowerStationImageDao {

    @Select("select * from power_station_image")
    List<PowerStationImage> getStationImage();

    @Select("select * from power_station_image where power_station_name=#{power_station_name}")
    List<PowerStationImage> getStationImageByStationName(String power_station_name);

    @Insert("insert into power_station_image(image_name,image_desc,power_station_name,image_info) values(#{e.image_name},#{e.image_desc},#{e.power_station_name},#{e.image_info,jdbcType=BLOB})")
    boolean insertImage(@Param("e") PowerStationImage photo);

    @Select("select * from power_station_image where id = 3")
    PowerStationImage downloadImage();

}
