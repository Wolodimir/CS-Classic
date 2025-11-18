package org.learning.tbank;

import java.util.Arrays;
import java.util.Random;

import static org.learning.tbank.SlidingWindow.showArray;

public class BinarySearch {

    public static void main(String[] args) {
        Random random = new Random();
        var a = new int[random.nextInt(10, 20)];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1, 20);
        }
        System.out.println(binarySearch(a, 10));
    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        showArray(arr);
        int l = 0, r = arr.length - 1;
        int result = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                if (arr[mid] == target) result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

}
