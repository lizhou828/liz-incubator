package com.liz.ocjpJava6.advanced.reflection.demo1;
import java.util.Date;
/**
 * Created by lizhou on 2016/9/29.
 */
public class Car extends BaseBean {
    private String name;

    private String id;

    private Boolean sellFlag;

    private int age;

    private double maxSpeed;

    private double minSpeed;

    private int driverPeople;

    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSellFlag() {
        return sellFlag;
    }

    public void setSellFlag(Boolean sellFlag) {
        this.sellFlag = sellFlag;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(double minSpeed) {
        this.minSpeed = minSpeed;
    }

    public int getDriverPeople() {
        return driverPeople;
    }

    public void setDriverPeople(int driverPeople) {
        this.driverPeople = driverPeople;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
