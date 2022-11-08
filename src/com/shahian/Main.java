package com.shahian;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        showMainThread();
//        example1();
//        exampleVotingSystem();
//        threadWaitingState();
//        threadInterrupt();
//        threadJoin();
        exampleVotingSystemWithPauseRandomAmount();
    }

    private static void showMainThread() {
        //main method use main thread that created by JVM
        System.out.println(Thread.currentThread().getName());
    }

    private static void exampleVotingSystemWithPauseRandomAmount() {

        //1- create voting method
        //2- create counting method
        //3- generate random number between 0 - 1000 milliseconds for voting
        //4- create method to counting vote every 2 seconds
        //5- voting and counting method should stop after 30 seconds
        //6- use boolean flag to stop task and set false as a default
        //7- main thread should pause after 30 seconds to let voting and counting threads execute
        //8- at the end of 30 seconds boolean flag should set be true for all tasks
        //9- finally print the total number of votes obtained by all three designs
        Design design1 = new Design(1, "design1");
        VotingRunnable2 votingRunnableD1 = new VotingRunnable2(design1);
        CountingRunnable2 countingRunnable1 = new CountingRunnable2(design1);
        Thread threadVotingRunnable1 = new Thread(votingRunnableD1);
        Thread threadCountingRunnable1 = new Thread(countingRunnable1);
        threadVotingRunnable1.start();
        threadCountingRunnable1.start();

        Design design2 = new Design(2, "design2");
        VotingRunnable2 votingRunnableD2 = new VotingRunnable2(design2);
        CountingRunnable2 countingRunnable2 = new CountingRunnable2(design2);
        Thread threadVotingRunnable2 = new Thread(votingRunnableD2);
        Thread threadCountingRunnable2 = new Thread(countingRunnable2);
        threadVotingRunnable2.start();
        threadCountingRunnable2.start();

        Design design3 = new Design(3, "design3");
        VotingRunnable2 votingRunnableD3 = new VotingRunnable2(design3);
        CountingRunnable2 countingRunnable3 = new CountingRunnable2(design3);
        Thread threadVotingRunnable3 = new Thread(votingRunnableD3);
        Thread threadCountingRunnable3 = new Thread(countingRunnable3);
        threadVotingRunnable3.start();
        threadCountingRunnable3.start();

        //pause the main thread for 30 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //at the 30 seconds all thread should be stopped.so set the true in boolean flag dor runnable classes
        votingRunnableD1.doStop = true;
        votingRunnableD2.doStop = true;
        votingRunnableD3.doStop = true;
        countingRunnable1.doStop = true;
        countingRunnable2.doStop = true;
        countingRunnable3.doStop = true;
        //finally, print the total number of votes obtained by all three designs
        System.out.println("voting has stopped for design " + design1.getName());
        System.out.println("total votes for " + design1.getName() + " : " + design1.getVotes().size());
        System.out.println("voting has stopped for design " + design2.getName());
        System.out.println("total votes for " + design2.getName() + " : " + design2.getVotes().size());
        System.out.println("voting has stopped for design " + design3.getName());
        System.out.println("total votes for " + design3.getName() + " : " + design3.getVotes().size());


    }

    private static void threadJoin() {
        //thread need to communicate with each other,
        // e.g. the thread could request other thread to wait unit it finishes its execution.that the threat class has method join that do this
        //to clear the join method  you  can comment the join method  and run
        //call the join method  marks thread start and finish then the average thread kicks off.

        int[] marks = new int[10];
        Thread marksThread = new Thread(new ThreadMarksForJoin(marks));
        Thread averageThread = new Thread(new ThreadAverageForJoin(marks));
        marksThread.start();
        try {
            marksThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        averageThread.start();
    }

    private static void threadInterrupt() throws InterruptedException {
        Thread thread = new Thread(new ThreadForInteruptRunnable());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        //Thread.sleep(3000);
        System.out.println("is interrupt? " + thread.isInterrupted());
    }

    private static void threadWaitingState() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("main Thread is printing " + i);
            if (i == 5) {
                System.out.println("waite for 2 seconds with sleep method");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void exampleVotingSystem() {
       /* create a voting system
       1- baking competition
       2- three finalist
       3- fixed duration to vote
         threads to handle votes coming in for three cake design and threads to count those votes
         create and start the vote and count threads*/
        Design design1 = new Design(1, "design1");
        VotingRunnable votingRunnableD1 = new VotingRunnable(design1);
        CountingRunnable countingRunnable1 = new CountingRunnable(design1);
        Thread threadVotingRunnable1 = new Thread(votingRunnableD1);
        Thread threadCountingRunnable1 = new Thread(countingRunnable1);
        threadVotingRunnable1.start();
        threadCountingRunnable1.start();

        Design design2 = new Design(2, "design2");
        VotingRunnable votingRunnableD2 = new VotingRunnable(design2);
        CountingRunnable countingRunnable2 = new CountingRunnable(design2);
        Thread threadVotingRunnable2 = new Thread(votingRunnableD2);
        Thread threadCountingRunnable2 = new Thread(countingRunnable2);
        threadVotingRunnable2.start();
        threadCountingRunnable2.start();

        Design design3 = new Design(3, "design3");
        VotingRunnable votingRunnableD3 = new VotingRunnable(design3);
        CountingRunnable countingRunnable3 = new CountingRunnable(design3);
        Thread threadVotingRunnable3 = new Thread(votingRunnableD3);
        Thread threadCountingRunnable3 = new Thread(countingRunnable3);
        threadVotingRunnable3.start();
        threadCountingRunnable3.start();

    }

    private static void example1() {
        for (int count = 1; count <= 3; count++) {
            ThreadExtendsClass threadExtendsClass = new ThreadExtendsClass(count);
            threadExtendsClass.start();
        }
    }
}
