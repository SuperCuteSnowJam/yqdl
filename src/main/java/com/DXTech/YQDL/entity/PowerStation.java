package com.DXTech.YQDL.entity;

public class PowerStation {
    private int id;
    private String name;
    private String voltage_level;
    private String desc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoltage_level() {
        return voltage_level;
    }

    public void setVoltage_level(String voltage_level) {
        this.voltage_level = voltage_level;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "PowerStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", voltage_level='" + voltage_level + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
