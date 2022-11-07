package com.shahian;

public class VotingRunnable implements Runnable {
    private Design design;

    public VotingRunnable(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        System.out.println("voting going on for design " + design.getName());
        design.getVotes().add(1L);
    }
}
