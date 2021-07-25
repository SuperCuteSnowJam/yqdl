package com.dxtech.yqdl.entity;

public class PowerStationImage {

    private int id;
    private String origin_name;
    private String file_type;
    private String file_size;
    private String file_name;
    private String file_path;
    private String file_desc;
    private int power_station_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public String getFile_desc() {
        return file_desc;
    }

    public void setFile_desc(String file_desc) {
        this.file_desc = file_desc;
    }

    public int getPower_station_id() {
        return power_station_id;
    }

    public void setPower_station_id(int power_station_id) {
        this.power_station_id = power_station_id;
    }

    @Override
    public String toString() {
        return "PowerStationImage{" +
                "id=" + id +
                ", origin_name='" + origin_name + '\'' +
                ", file_type='" + file_type + '\'' +
                ", file_size='" + file_size + '\'' +
                ", file_name='" + file_name + '\'' +
                ", file_path='" + file_path + '\'' +
                ", file_desc='" + file_desc + '\'' +
                ", power_station_id=" + power_station_id +
                '}';
    }
}
