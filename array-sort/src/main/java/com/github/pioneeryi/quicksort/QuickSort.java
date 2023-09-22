package com.github.pioneeryi.quicksort;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快排：每一轮下来，pivot左边的都比pivot小，pivot右边的都比pivot大
     */
    public static int[] sort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }


    private static void quicksort(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            quicksort(nums, left, p - 1);
            quicksort(nums, p + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 4, 1, 2};
        int[] res = sort(nums);
        System.out.println(Arrays.toString(res));
    }
}
