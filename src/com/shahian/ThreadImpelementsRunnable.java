package com.shahian;

public class ThreadImpelementsRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("ThreadImpelementsRunnable :" + i);
        }
    }
}
