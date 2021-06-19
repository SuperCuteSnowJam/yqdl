package com.DXTech.YQDL.entity;

public class PowerStation {
    private int id;
    private String power_level;
    private String power_station_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPower_level() {
        return power_level;
    }

    public void setPower_level(String power_level) {
        this.power_level = power_level;
    }

    public String getPower_station_name() {
        return power_station_name;
    }

    public void setPower_station_name(String power_station_name) {
        this.power_station_name = power_station_name;
    }
}
