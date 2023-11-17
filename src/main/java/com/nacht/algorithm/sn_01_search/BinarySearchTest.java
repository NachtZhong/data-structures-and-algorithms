package com.nacht.algorithm.sn_01_search;

/**
 * @author Nacht
 * Created on 2023/11/18 01:39
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 5, 6, 7, 9, 10, 11, 16, 19, 21, 23};
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 3));
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 6));
        System.out.println(binarySearch(arr, 7));
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 11));
        System.out.println(binarySearch(arr, 16));
        System.out.println(binarySearch(arr, 19));
        System.out.println(binarySearch(arr, 21));
        System.out.println(binarySearch(arr, 23));
//        int[] arr = new int[]{-1,0,3,5,9,12};
//        System.out.println(binarySearch(arr, 2));
    }

    /**
     * 二分查找数组中特定元素
     * @param nums 要查找的数组
     * @param target 要查找的元素
     * @return 匹配上的索引下标, 如果没有匹配上返回-1
     */
    public static int binarySearch(int[] nums, int target){
        int result = -1;
        int i = 0, j = nums.length - 1;
        while(i <= j){
//            System.out.format("searching %d - %d", i, j);
//            System.out.println();
            int middle = i + (j - i) / 2;
            if(nums[middle] == target){
                result = middle;
                break;
            }else if (target < nums[middle]){
                j = middle - 1;
            }else{
                i = middle + 1;
            }
        }
        return result;
    }

}
