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
        System.out.println(Arrays.toString(findRange(arr, 4)));
    }

    public static int[] showTargetRange(int[] arr, int target) {
        int[] answer = new int[]{-1, -1};
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

    public static int[] findRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        if (left == -1) return new int[]{};  // нет target

        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    private static int findLeft(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target) res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static int findRight(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                if (nums[mid] == target) res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

}
