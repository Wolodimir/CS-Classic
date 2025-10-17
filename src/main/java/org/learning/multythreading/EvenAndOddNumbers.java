package org.learning.multythreading;


public class EvenAndOddNumbers {

    private static final int MAX_NUMBER = 20;
    private static final Object lock = new Object();
    private static boolean isEvenTurn = true;

    public static void main(String[] args) {

        Thread threadEven = new Thread(() -> {
            for (int i = 2; i <= MAX_NUMBER; i += 2) {
                synchronized (lock) {
                    while (!isEvenTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even Number from evenThread: " + i);
                    isEvenTurn = false;
                    lock.notify();
                }
            }
        });
        Thread threadOdd = new Thread(() -> {
            for (int i = 1; i <= MAX_NUMBER; i += 2) {
                synchronized (lock) {
                    while (isEvenTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd Number from oddThread: " + i);
                    isEvenTurn = true;
                    lock.notify();
                }
            }
        });
        threadOdd.start();
        threadEven.start();


    }

}
