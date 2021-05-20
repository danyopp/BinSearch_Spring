package com.yopp.spring.BinSearch.BinarySearch;

public class BubbleSort implements SortAlgorithm{

    //    Average Case: O(n^2)
    public int[] sort(int[] numbers) {
        int length = numbers.length;
            for (int i = 0; i < length-1; i++){
                for(int j = 0; j < length-i-1; j++){
                    if(numbers[j] > numbers[j+1]){
                        swap(numbers, j, j+1);
                    }
                }
            }
        return numbers;
    }
}
