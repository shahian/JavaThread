package com.shahian;

public class CountingRunnable2 implements Runnable {

    private Design design;
    boolean doStop = false;

    public CountingRunnable2(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        while (!doStop) {

            System.out.println("Design " + design.getName() + " has " + design.getVotes().size() + " votes");
            //pause the thread after 2 second
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
