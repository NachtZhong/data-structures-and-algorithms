package com.nacht.algorithm.sn_02_sort;

/**
 * @author Nacht
 * Created on 2023/11/20 14:53
 */
public class RadixSort {

    /**
     * 基数排序
     * @param nums 待排序数组
     * @return 排序后数组
     */
    public static int[] radixSort(int[] nums){
        int maxDigit = getMaxDigit(nums);
        for(int i = 1; i <= maxDigit; i *= 10){
            countSort(nums, i);
        }
        return nums;
    }



    /**
     * 获取数组中的最大数(包括负数的绝对值)
     * @param nums 数字
     * @return 最大数
     */
    private static int getMaxDigit(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(Math.abs(max), Math.abs(num));
        }
        return max;
    }


    /**
     * 对num%exp的结果进行计数排序
     * @param nums 待排序数组
     * @param divide 取模数
     * @return 排序后数组
     */
    private static int[] countSort(int[] nums, int divide){
        /* 计数数组 */
        int[] negativeArr = new int[10];
        int[] positiveArr = new int[10];
        /* 记录一下负数的个数 */
        int negativeNumCount = 0;
        for(int num: nums){
            if(num < 0){
                negativeArr[getDivideResult(num, divide)] += 1;
            }else{
                positiveArr[getDivideResult(num, divide)] += 1;
            }
        }
        /* 对每个数组进行累加操作, 得出各个数字在新数组的位置, 负向数组要倒序遍历 */
        for(int i = negativeArr.length - 1; i >= 0; i--){
            negativeNumCount += negativeArr[i];
            if(i != negativeArr.length - 1){
                negativeArr[i] += negativeArr[i + 1];
            }
        }
        /* 正向数组的位置需要先加上负数总数 */
        positiveArr[0] += negativeNumCount;
        for(int i = 1; i < positiveArr.length; i++){
            positiveArr[i] += positiveArr[i- 1];
        }
        /* 目标数组 */
        int[] newNumArr = new int[nums.length];
        /* 倒序遍历原数组, 填入元素 */
        for(int i = nums.length - 1; i >= 0; i--){
            int divideResult = getDivideResult(nums[i], divide);
            if(nums[i] < 0){
                int arrIndex = negativeArr[divideResult] - 1;
                negativeArr[divideResult]--;
                newNumArr[arrIndex] = nums[i];
            }else{
                int arrIndex = positiveArr[divideResult] - 1;
                positiveArr[divideResult]--;
                newNumArr[arrIndex] = nums[i];
            }
        }
        /* 拷贝回原数组 */
        for(int i = 0; i < nums.length; i++){
            nums[i] = newNumArr[i];
        }
        return nums;
    }

    /**
     * 获取某个数除以被除数后的整数位
     * e.g. num = 15, divide = 1 => 5, num = 15, divide = 10 => 1
     */
    private static int getDivideResult(int num, int divide){
        return (Math.abs(num) /divide) % 10;
    }


}
