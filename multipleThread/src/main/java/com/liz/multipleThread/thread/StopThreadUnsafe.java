package com.liz.multipleThread.thread;

/**
 * Created by Frank on 2016/7/13
 */
public class StopThreadUnsafe {

    public static User u = new User();
    public static class User {
        private int id;
        private String name;

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

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }






    public static class ChangeObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    int v =  (int) (System.currentTimeMillis()/1000);
                    System.out.println(System.nanoTime()+" 写线程"+ this.getName() +"：v=" + v);
                    u.setId(v);
                    System.out.println(System.nanoTime()+" 写线程"+ this.getName() +"：写一半数据,user=" + u);
                    //do sth else
                    try {
                        Thread.sleep(100);//使当前线程暂停millis所指定的毫秒，转到执行其它线程
                        System.out.println(System.nanoTime()+" 写线程"+ this.getName() +"：写一半数据后休眠100毫秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                    System.out.println(System.nanoTime()+" 写线程"+ this.getName() +"：完成了另一半数据的写入,user=" + u);
                }
                Thread.yield();//暂停当前正在执行的线程对象，并执行其他线程(这里的其他也包含当前线程)
                System.out.println(System.nanoTime()+" 写线程"+ this.getName() +"：Thread.yield()......");
            }
        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (u){
                    System.out.println(System.nanoTime()+" 读线程"+ this.getName() +"：user=" + u.toString());
                    if(u.getId() !=  Integer.parseInt(u.getName() == null ? "0":u.getName())){
                        System.out.println(System.nanoTime()+" 读线程"+ this.getName() +"：读取到脏数据，id 与name不一致" + u.toString()+"---------------------------------");
                    }
                }
                Thread.yield(); //暂停当前正在执行的线程对象，并执行其他线程(这里的其他也包含当前线程)
                System.out.println(System.nanoTime()+" 读线程"+ this.getName() +"：Thread.yield()......");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new ReadObjectThread();
        readThread.start();
        System.out.println(System.nanoTime()+" 读线程" + readThread.getName() + "：创建并启动成功!");
        while (true){
            Thread thread = new ChangeObjectThread();
            thread.start();
            System.out.println(System.nanoTime()+" 写线程"+ thread.getName() +"：创建并启动成功!");
            Thread.sleep(150);//使当前线程暂停millis所指定的毫秒，转到执行其它线程
            System.out.println(System.nanoTime()+" 写线程"+ thread.getName()+"：休眠150毫秒");
            thread.stop();
            System.out.println(System.nanoTime()+" 写线程"+ thread.getName()+"：被强制停止了....");
        }
    }


}
