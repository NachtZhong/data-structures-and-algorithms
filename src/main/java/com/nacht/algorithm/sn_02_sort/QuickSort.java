package com.nacht.algorithm.sn_02_sort;

import java.util.Arrays;

/**
 * @author Nacht
 * Created on 2023/11/19 18:57
 */
public class QuickSort {

    /**
     * 快速排序
     * @param nums 要进行排序的数组
     * @return 排序后的数组
     */
    public static int[] quickSort(int[] nums){
        return quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快速排序实现代码
     * @param nums 要进行排序的子数组
     * @param left 左指针
     * @param right 右指针
     * @return 排序后数组
     */
    private static int[] quickSort(int[] nums, int left, int right){
        if(left >= right){
            return nums;
        }
        /* 基准数 */
        int i = partition(nums, left, right);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
        return nums;
    }

    private static int partition(int[] nums , int left, int right){
        int pivotIndex = left + (right - left) / 2;
        int pivot = nums[pivotIndex];
        nums[pivotIndex] = nums[left];
        nums[left] = pivot;
        while(left < right){
            while(left < right && nums[right] >= pivot){
                right --;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot){
                left ++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

}
