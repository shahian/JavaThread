package com.shahian;

public class ThreadForInteruptRunnable implements Runnable {
    //use interrupt exception to show exception
//    @Override
//    public void run() {
//        for (int i = 1; i <= 100; i++) {
//            System.out.println("test Thread for interrupt  :" + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    // use break insted of e.printStackTrace to terminate when interrupt caused
//    @Override
//    public void run() {
//        for (int i = 1; i <= 100; i++) {
//            System.out.println("test Thread for interrupt  :" + i);
//            try {
//                Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            break;
//        }
//
//        }
//    }
//// check the value of interrupt the current thread but when run the flag of value is false
//    @Override
//    public void run() {
//        for (int i = 1; i <= 100; i++) {
//            System.out.println("test Thread for interrupt  :" + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("current thread interrupt " + Thread.currentThread().isInterrupted());
//                break;
//            }
//        }
//    }
    //use static interrupt instead of try catch
    @Override
    public void run(){
//       to show the here message, in the main method we should move the sleep method after interrupt method
        for (int i=1;i<=100;i++){
            if (Thread.interrupted()) {
                System.out.println("Thread received interrupt ");
                break;
            }
        }
    }
}
