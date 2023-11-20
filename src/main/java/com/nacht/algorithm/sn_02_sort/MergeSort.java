package com.nacht.algorithm.sn_02_sort;

/**
 * @author Nacht
 * Created on 2023/11/19 21:37
 */
public class MergeSort {

    /**
     * 归并排序
     * @param nums 要进行排序的数组
     * @return 排序后的数组
     */
    public static int[] mergeSort(int[] nums){
        return mergeSort(nums, 0, nums.length - 1);
    }


    /**
     * 归并排序
     * @param nums 要排序的数组
     * @param left 左指针
     * @param right 右指针
     * @return 排序后的数组
     */
    private static int[] mergeSort(int[] nums, int left, int right) {
        if(left >= right){
            return nums;
        }
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, right);
        return nums;
    }

    /**
     * 合并数组特定位置的子数组
     * @param nums 数组
     * @param left 左指针
     * @param right 右指针
     */
    private static void merge(int[] nums, int left, int right){
        /* 左子数组 left -> middle, 右子数组 middle + 1 -> right */
        int middle = left + (right - left) / 2;
        /* 临时数组, 用来存放合并后的数组 */
        int[] tmpArray = new int[right - left + 1];
        int leftArrayIndex = left, rightArrayIndex = middle + 1;
        for(int tmpArrayIndex = 0; tmpArrayIndex < tmpArray.length; tmpArrayIndex++){
            if(leftArrayIndex > middle){
                /*左子数组到底, 从右子数组拿*/
                tmpArray[tmpArrayIndex] = nums[rightArrayIndex];
                rightArrayIndex++;
            } else if (rightArrayIndex > right) {
                /*右子数组到底, 从左子数组拿*/
                tmpArray[tmpArrayIndex] = nums[leftArrayIndex];
                leftArrayIndex++;
            }else{
                /*从较小的一个当前元素的数组拿*/
                if(nums[leftArrayIndex] <= nums[rightArrayIndex]){
                    tmpArray[tmpArrayIndex] = nums[leftArrayIndex];
                    leftArrayIndex++;
                }else{
                    tmpArray[tmpArrayIndex] = nums[rightArrayIndex];
                    rightArrayIndex++;
                }
            }
        }
        /* 临时数组复制到原数组特定位置 */
        for(int num : tmpArray){
            nums[left] = num;
            left++;
        }
    }
}
