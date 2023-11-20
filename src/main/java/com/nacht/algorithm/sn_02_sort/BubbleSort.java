package com.nacht.algorithm.sn_02_sort;

/**
 * @author Nacht
 * Created on 2023/11/18 21:31
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param nums 待排序数组
     * @return 排序后的数组
     */
    public static int[] bubbleSort(int[] nums){
        int length = nums.length;
        for(int i = 0; i <= length - 2; i++){
            boolean hasChanged = false;
            for(int j = 0; j <= length - 2 - i; j++){
                if(nums[j] > nums[j + 1]){
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                    hasChanged = true;
                }
            }
            if(!hasChanged){
                break;
            }
        }
        return nums;
    }

}
