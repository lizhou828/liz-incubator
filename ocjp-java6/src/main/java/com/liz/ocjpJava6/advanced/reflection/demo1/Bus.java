package com.liz.ocjpJava6.advanced.reflection.demo1;
import java.util.Date;
/**
 * Created by lizhou on 2016/9/29.
 */
public class Bus extends BaseBean    {
    private String name;

    private String id;

    private Boolean sellFlag;

    private int age;

    private double maxSpeed;

    private double minSpeed;

    private long driverPeople;//和car類型不同

    private int driverYear;//car沒有這個

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

    public long getDriverPeople() {
        return driverPeople;
    }

    public void setDriverPeople(long driverPeople) {
        this.driverPeople = driverPeople;
    }

    public int getDriverYear() {
        return driverYear;
    }

    public void setDriverYear(int driverYear) {
        this.driverYear = driverYear;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
