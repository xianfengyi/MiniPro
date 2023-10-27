package com.github.pioneeryi;

public class RotateArraySearch {

    public static void main(String[] args) {
        int[] target = new int[]{4,5,6,7,8,1,2,3};

        int res = search(target, 8);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int low, int high) {
        if (low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(nums[mid]==target){
            return mid;
        }
        // 如果最小的小于最大的，那么说明是正常升序数组
        if(nums[low]<nums[high]){
            if (nums[mid]>target){
                return binarySearch(nums,target,low,mid-1);
            }else{
                return binarySearch(nums,target,mid+1,high);
            }
        }else{
            if (nums[mid]>target){
                if(nums[low]>target){
                    return binarySearch(nums,target,mid+1,high);
                }else{
                    return binarySearch(nums,target,low,mid-1);
                }
            }else{
                if(nums[high]>=target){
                    return binarySearch(nums,target,mid+1,high);
                }else{
                    return binarySearch(nums,target,low,mid-1);
                }
            }
        }
    }
}
