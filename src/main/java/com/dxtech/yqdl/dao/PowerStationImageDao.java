package com.dxtech.yqdl.dao;

import com.dxtech.yqdl.entity.PowerStationImage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PowerStationImageDao {

    @Select("select * from power_station_image")
    List<PowerStationImage> getStationImage();

    @Select("select a.* from power_station_image a left join power_station b on a.power_station_id = b.id where b.power_station_name=#{power_station_name}")
    List<PowerStationImage> getStationImageByStationName(String power_station_name);

    @Insert("insert into power_station_image(origin_name,file_type,file_size,file_name,file_path,file_desc,file_qrcode_path,power_station_id) " +
            "values(#{image.origin_name},#{image.file_type},#{image.file_size},#{image.file_name},#{image.file_path},#{image.file_desc},#{image.file_qrcode_path},${image.power_station_id})")
    boolean insertImage(@Param("image") PowerStationImage image);

    @Select("select * from power_station_image where origin_name = #{f_n}")
    PowerStationImage getImageByFileName(String f_n);

    /**
     * 根据现有文件名称查询文件
     * @param f_n
     * @return
     */
    @Select("select * from power_station_image where file_name = #{f_n}")
    PowerStationImage getImageByNowFileName(String f_n);

    @Select("select * from power_station_image where origin_name like '%${f_n}%'")
    List<PowerStationImage> listImageByFileName(String f_n);

    /**
     * 根据文件ID获取文件
     * @param id
     * @return
     */
    @Select("select * from power_station_image where id = ${id}")
    PowerStationImage getImageById(int id);

    @Delete("delete from power_station_image where id = ${id}")
    void deleteFileById(int id);

}
