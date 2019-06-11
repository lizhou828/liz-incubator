package com.liz.ocjpJava6.advanced.reflection.demo1;

/**
 * Created by lizhou on 2016/9/29.
 */
public class Dog extends FourLegsAnimal implements Animal {

    private String name;

    private int age;

    private int legsNum;

    public String nickName;

    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
        this.age = 10;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age, int legsNum) {
        this.name = name;
        this.age = age;
        this.legsNum = legsNum;
    }

    private void sleep(int x) {
        System.out.println(name + "睡觉" + x + "分钟");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLegsNum() {
        return legsNum;
    }

    public void setLegsNum(int legsNum) {
        this.legsNum = legsNum;
    }

    @Override
    public String eat(String obj) {
        System.out.println(name + "吃"+ obj);
        return null;
    }

    @Override
    public int run(int obj) {
        System.out.println("跑，速度："+ obj);
        return 0;
    }


    private static void play() {
        System.out.println("狗狗自己玩啊玩");
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", legsNum=" + legsNum +
                ", nickName='" + nickName + '\'' +
                "} " + super.toString();
    }

    @Override
    public void hasFourLegs() {
        legsNum = 4;
    }

    @Override
    public String runSpeed() {
        if(this.legsNum == 4){
            return super.runSpeed();
        }else{
            return "show";
        }
    }
}
