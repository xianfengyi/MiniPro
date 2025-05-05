package com.github.pioneeryi;

public class BinarySearch {

    private int[] numbers;

    public BinarySearch(int[] numbers) {
        this.numbers = numbers;
    }

    // 查找指定值
    public int find(int value) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] == value) {
                return mid;
            } else if (numbers[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 查找小于等于的最大值
    public int findFloor(int value) {
        int low = 0;
        int high = numbers.length - 1;
        // 关键点1:这里是小于
        while (low < high) {
            // 关键点2:这里是取高位
            int mid = (low + high + 1) / 2;
            if (numbers[mid] > value) {
                // 关键点3
                high = mid - 1;
            } else {
                // 关键点4
                low = mid;
            }
        }
        // 关键点5
        return numbers[low] > value ? -1 : low;
    }

    // 查找小于等于的最大值
    public int findFloor1(int value) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] <=value) {
                if(mid==high||numbers[mid+1]>value){
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        return  -1;
    }

    // 查找大于等于的最小值
    public int findHead(int value) {
        int low = 0;
        int high = numbers.length - 1;
        // 关键点1:这里是小于
        while (low < high) {
            // 关键点2:这里是取低位
            int mid = (low + high) / 2;
            if (numbers[mid] < value) {
                // 关键点3
                low = mid + 1;
            } else {
                // 关键点4
                high = mid;
            }
        }
        // 关键点5
        return numbers[high] > value ? high : -1;
    }

    // 查找大于等于的最小值
    public int findHead1(int value) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (numbers[mid] >= value) {
                if (mid == 0 || numbers[mid - 1] < value) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
