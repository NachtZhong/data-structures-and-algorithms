package com.nacht.algorithm.sn_02_sort;

/**
 * @author Nacht
 * Created on 2023/11/18 19:04
 */
public class SelectionSort {

    /**
     * 选择排序
     * @param nums 要进行排序的数组
     */
    public static int[] selectionSort(int[] nums){
        for(int i = 0; i <= nums.length - 2; i++){
            int min = nums[i], minIndex = i;
            for(int j = i + 1; j <= nums.length - 1; j++){
                if(nums[j] < min){
                    min = nums[j];
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    /**
     * 交换数组元素
     * @param nums 数组
     * @param i 第一索引位置
     * @param j 第二索引位置
     */
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
