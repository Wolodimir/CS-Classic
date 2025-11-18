package org.learning.tbank;

import java.util.Arrays;
import java.util.Random;

import static org.learning.tbank.SlidingWindow.showArray;

public class NumbersRange {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10);
        }
        Arrays.sort(arr);
        showArray(arr);
        System.out.println(Arrays.toString(showTargetRange(arr, 4)));
    }

    public static int[] showTargetRange(int[] arr, int target) {
        int[] answer = new int[] {-1, -1};
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == target) {
                answer[0] = i;
                break;
            }
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            if (arr[j] == target) {
                answer[1] = j;
                break;
            }
        }
        if (answer[0] == -1) {
            return new int[]{};
        }
        return answer;
    }

}
