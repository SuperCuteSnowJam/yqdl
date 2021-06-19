package com.DXTech.YQDL.entity;

public class PowerStationImage {

    private int id;
    private String image_name;
    private String image_desc;
    private String power_station_name;
    private byte[] image_info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getImage_desc() {
        return image_desc;
    }

    public void setImage_desc(String image_desc) {
        this.image_desc = image_desc;
    }

    public String getPower_station_name() {
        return power_station_name;
    }

    public void setPower_station_name(String power_station_name) {
        this.power_station_name = power_station_name;
    }

    public byte[] getImage_info() {
        return image_info;
    }

    public void setImage_info(byte[] image_info) {
        this.image_info = image_info;
    }
}
