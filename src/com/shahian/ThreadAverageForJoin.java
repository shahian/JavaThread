package com.shahian;

public class ThreadAverageForJoin implements Runnable {
    int[] marks;

    public ThreadAverageForJoin(int[] marks) {
        this.marks = marks;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i <10; i++) {
            Double point = Math.random() * 100;
            marks[i] = point.intValue();
            System.out.println("adding mark : " + marks[i]);
            sum += marks[i];
        }
        System.out.println("Average " + sum / 10);
    }
}
