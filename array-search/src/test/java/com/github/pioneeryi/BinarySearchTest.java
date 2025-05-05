package com.github.pioneeryi;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class BinarySearchTest {

    @Test
    public void find() {
        int[] numbers = new int[]{1, 3, 5, 7, 9, 11};
        BinarySearch binarySearch = new BinarySearch(numbers);
        int index = binarySearch.find(3);
        Assert.assertEquals(1, index);
    }

    @Test
    public void findFloor() {
        int[] numbers = new int[]{1, 3, 5, 7, 9, 11};
        BinarySearch binarySearch = new BinarySearch(numbers);
        int index = binarySearch.findFloor(4);
        Assert.assertEquals(1, index);
    }

    @Test
    public void findFloor1() {
        int[] numbers = new int[]{1, 3, 5, 7, 9, 11};
        BinarySearch binarySearch = new BinarySearch(numbers);
        int index = binarySearch.findFloor1(4);
        Assert.assertEquals(1, index);
    }

    @Test
    public void findHead() {
        int[] numbers = new int[]{1, 3, 5, 7, 9, 11};
        BinarySearch binarySearch = new BinarySearch(numbers);
        int index = binarySearch.findHead(4);
        Assert.assertEquals(2, index);
    }

    @Test
    public void findHead1() {
        int[] numbers = new int[]{1, 3, 5, 7, 9, 11};
        BinarySearch binarySearch = new BinarySearch(numbers);
        int index = binarySearch.findHead1(4);
        Assert.assertEquals(2, index);
    }

    @Test
    public void testDFF(){
        int res = subarraysWithKDistinct(new int[]{1,2,1,2,},2);
        Assert.assertEquals(7,res);

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int res =0;
        int len = nums.length;
        if(k==1){
            return len;
        }
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if((j-i+1)<k){
                    continue;
                }
                int count = diffCount(nums,i,j);
                if(count==k){
                    res++;
                }
                if(count>k){
                    break;
                }
            }
        }
        return res;
    }

    private int diffCount(int[] nums,int start,int end){
        int count=0;
        Set<Integer> set = new HashSet();
        for(int i=start;i<=end;i++){
            if(!set.contains(nums[i])){
                count++;
                set.add(nums[i]);
            }
        }
        return count;
    }
}