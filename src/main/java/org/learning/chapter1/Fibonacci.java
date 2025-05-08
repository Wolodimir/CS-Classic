package org.learning.chapter1;

import java.util.stream.IntStream;

public class Fibonacci {

    private int last = 0, next = 1;

    public static void main(String[] args) {
        System.out.println(fibRec(10));
        System.out.println(fibIter(10));

        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibStream().limit(10).forEachOrdered(System.out::println);
    }

    public static int fibRec(int n) {
        if (n < 2) {
            return n;
        }
        return fibRec(n - 1) + fibRec(n - 2);
    }

    public static int fibIter(int n) {
        if (n < 2) {
            return n;
        }
        int prev = 0, next = 1, temp = 0;
        for (int i = 0; i < n; i++) {
            temp = prev + next;
            prev = next;
            next = temp;
        }
        return temp;
    }

    public IntStream fibStream() {
        return IntStream.generate(() -> {
            int oldLast = last;
            last = next;
            next = oldLast + next;
            return oldLast;
        });
    }

}
