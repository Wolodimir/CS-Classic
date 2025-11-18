package org.learning.tbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MergeArrays {

    /**
     * Реализованая генерация тестовых данных нарушает ограничение задачи
     * элементы в массивах строго уникальны
     * */
    public static void main(String[] args) {
        //var a = new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17};
        //var b = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18};
        Random random = new Random();
        var a = new int[random.nextInt(10, 20)];
        var b = new int[random.nextInt(10, 20)];

        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1, 20);
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = random.nextInt(1, 20);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        showArray(a);
        showArray(b);
        mergeArrays(a, b);
    }

    public static void mergeArrays(int[] a, int[] b) {
        int i = 0, j = 0;
        int n1 = a.length, n2 = b.length;
        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (a[i] > b[j]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }

        while (i < n1) System.out.print(a[i++] + " ");
        while (j < n2) System.out.print(b[j++] + " ");
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
