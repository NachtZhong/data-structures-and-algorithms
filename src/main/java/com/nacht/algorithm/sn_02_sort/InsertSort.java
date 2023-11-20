package com.nacht.algorithm.sn_02_sort;

/**
 * @author Nacht
 * Created on 2023/11/18 22:12
 */
public class InsertSort {


    /**
     * 插入排序
     * @param nums 待排序数组
     * @return 排序后数组
     */
    public static int[] insertSort(int[] nums){
        int length = nums.length;
        for(int i = 1; i <= length - 1; i++){
            int j = i;
            int value = nums[j];
            while(j >= 1 && value < nums[j - 1]){
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = value;
        }
        return nums;
    }

}
