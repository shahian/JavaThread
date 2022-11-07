package com.shahian;

public class ThreadExtendsClass extends Thread {
    private int count;

    public ThreadExtendsClass() {

    }

    public ThreadExtendsClass(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(i+ " from ThreadExtendsClass :" + count);
        }
    }
}
