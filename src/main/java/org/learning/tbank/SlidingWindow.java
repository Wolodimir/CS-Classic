package org.learning.tbank;


import java.util.Arrays;
import java.util.Random;

public class SlidingWindow {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        showArray(arr);
        System.out.println("Минимальная разница: " + minWindowDifference(arr, 3));
    }

    public static int minWindowDifference(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 2) {
            return 0;
        }
        Arrays.sort(arr);
        showArray(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.length - k; i++) {
            int currentDiff = arr[i + k - 1] - arr[i];
            minDiff = Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }

    public static void showArray(int[] arr) {
        System.out.print("[");
        for (int j : arr) {
            System.out.print(j + ", ");
        }
        System.out.print("]");
        System.out.println();
    }


}

