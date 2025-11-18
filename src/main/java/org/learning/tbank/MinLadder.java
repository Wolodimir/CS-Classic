package org.learning.tbank;

import java.util.Random;
import java.util.stream.Stream;

public class MinLadder {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[random.nextInt(10, 20)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 20);
        }
        showArray(arr);
        System.out.println(minLadder(arr, 6));

    }

    public static int minLadder(int[] buildings, int targetBuild) {
        int targetLadder = buildings[targetBuild];
        int leftLadder = buildings[0];
        int rightLadder = buildings[buildings.length - 1];
        for (int i = 1; i <= targetBuild; i++) {
            if (leftLadder <= Math.abs(buildings[i] - buildings[i - 1]) || buildings[i] < leftLadder) {
                leftLadder = buildings[i];
            }
        }
        for (int i = buildings.length - 2; i >= targetBuild; i--) {
            if (rightLadder <= Math.abs(buildings[i] - buildings[i + 1]) || buildings[i] < rightLadder) {
                rightLadder = buildings[i];
            }
        }

        System.out.println("Левая: " + leftLadder + ", Правая: " + rightLadder + ", Целевая: " + targetLadder);
        return Stream.of(leftLadder, rightLadder, targetLadder)
                .min(Integer::compare)
                .get();
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

