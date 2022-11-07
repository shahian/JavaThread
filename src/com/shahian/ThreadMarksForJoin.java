package com.shahian;

public class ThreadMarksForJoin implements Runnable {
    int[] marks;

    public ThreadMarksForJoin(int[] marks) {
        this.marks = marks;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Double point = Math.random() * 100;
            marks[i]=point.intValue();
            System.out.println("Marked Entered : " + marks[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
