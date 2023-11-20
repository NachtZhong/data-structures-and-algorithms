package com.nacht.algorithm.sn_02_sort;


/**
 * @author Nacht
 * Created on 2023/11/19 23:17
 */
public class CountSort {


    public static int[] countSort(int[] nums){
        int[] negativeArr = new int[50001];
        int[] positiveArr = new int[50001];
        for(int num: nums){
            if(num < 0){
                negativeArr[-num] += 1;
            }else{
                positiveArr[num] += 1;
            }
        }
        int currentIndex = 0;
        for(int i = negativeArr.length - 1; i >= 0; i--){
            int count = negativeArr[i];
            while (count > 0){
                nums[currentIndex] = -i;
                count--;
                currentIndex++;
            }
        }
        for(int i = 0; i < positiveArr.length; i++){
            int count = positiveArr[i];
            while (count > 0){
                nums[currentIndex] = i;
                count--;
                currentIndex++;
            }
        }
        return nums;
    }

}
