package com.shahian;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //main method use main thread that created by JVM
        System.out.println(Thread.currentThread().getName());
        //user Thread extends thread class
        ThreadExtendsClass threadExtendsClass1 = new ThreadExtendsClass();
        //threadExtendsClass1.start();

        //user Thread implements Runnable Interface
        ThreadImpelementsRunnable threadImpelementsRunnable1 = new ThreadImpelementsRunnable();
        Thread thread = new Thread(threadImpelementsRunnable1);
        //thread.start();

//        example1();
//        exampleVotingSystem();
//        threadWaitngState();
//        threadInterupt();
        threadJoin();
    }

    private static void threadJoin() {
        //to clear the join method  you  can comment the join method  and run
//       call the join method  marks thread start and finish then the averega thread kiks off.
                 
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

    private static void threadInterupt() throws InterruptedException {
        Thread thread = new Thread(new ThreadForInteruptRunnable());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        //Thread.sleep(3000);
        System.out.println("is interrupt? " + thread.isInterrupted());
    }

    private static void threadWaitngState() {
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
         threades to handle votes coming in for three cake design and threads to count those votes
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
