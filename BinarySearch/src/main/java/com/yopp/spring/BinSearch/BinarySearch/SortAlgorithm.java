package com.yopp.spring.BinSearch.BinarySearch;

public interface SortAlgorithm {
    int[] sort(int[] numbers);

    //default swap function to swap to points in array
    default void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
