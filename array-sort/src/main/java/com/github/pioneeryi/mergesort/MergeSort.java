package com.github.pioneeryi.mergesort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergesort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergesort(nums, left, mid);
            mergesort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int size = right - left + 1;
        int[] temp = new int[size];

        int k = 0;
        int indexLeft = left;
        int indexRight = mid + 1;
        while (indexLeft <= mid && indexRight <= right) {
            if (nums[indexLeft] <= nums[indexRight]) {
                temp[k++] = nums[indexLeft];
                indexLeft++;
            } else {
                temp[k++] = nums[indexRight];
                indexRight++;
            }
        }
        while (indexLeft <= mid) {
            temp[k++] = nums[indexLeft];
            indexLeft++;
        }
        while (indexRight <=right) {
            temp[k++] = nums[indexRight];
            indexRight++;
        }
        for (int i = 0; i < size; i++) {
            nums[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 4, 1, 2};
        int[] res = sort(nums);
        System.out.println(Arrays.toString(res));
    }
}
