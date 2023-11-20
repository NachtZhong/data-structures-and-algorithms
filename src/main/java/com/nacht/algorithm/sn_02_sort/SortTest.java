package com.nacht.algorithm.sn_02_sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Nacht
 * Created on 2023/11/18 19:04
 */
public class SortTest {

    public static void main(String[] args) {
        int[][] testArrays = new int[][]{
                {20, 12, 45, 19, 91, 55},
                {-1, 0, 1},
                {1, -3, -9, -2, -1},
                {5, 2, 3, 1}
        };
        for(int[] arr: testArrays){
            System.out.println(Arrays.toString(SelectionSort.selectionSort(arr.clone())));
            System.out.println(Arrays.toString(BubbleSort.bubbleSort(arr.clone())));
            System.out.println(Arrays.toString(InsertSort.insertSort(arr.clone())));
            System.out.println(Arrays.toString(QuickSort.quickSort(arr.clone())));
            System.out.println(Arrays.toString(MergeSort.mergeSort(arr.clone())));
            System.out.println(Arrays.toString(CountSort.countSort(arr.clone())));
            System.out.println(Arrays.toString(RadixSort.radixSort(arr.clone())));
        }
    }

}
