package com.shahian;

public class CountingRunnable implements Runnable{

    private Design design;
    public  CountingRunnable(Design design){
        this.design=design;
    }
    @Override
    public void run() {
        System.out.println("Design " + design.getName() + " has " + design.getVotes().size() + " votes");

    }
}
