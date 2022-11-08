package com.shahian;

public class VotingRunnable2 implements Runnable {
    private Design design;
    boolean doStop = false;

    public VotingRunnable2(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        while (!doStop) {
            System.out.println("voting going on for design " + design.getName());
            design.getVotes().add(1L);

            //to generate a random method between 0 - 1000
            Double sleepFor = Math.random() * 1000;

            try {
                Thread.sleep(sleepFor.longValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
