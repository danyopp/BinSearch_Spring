package com.yopp.spring.BinSearch.BinarySearchImpl;

public class SelectionSort implements SortAlgorithm{

    //Average Case O(n^2)
    public int[] sort(int[] numbers){
        int masterCounter, subCounter, curMin;
        int size = numbers.length;
        for(masterCounter = 0; masterCounter < size; masterCounter++){
            curMin = masterCounter;
            for(subCounter = masterCounter+1; subCounter < size; subCounter++){
                if(numbers[subCounter] < numbers[curMin]){
                    curMin =  subCounter;
                }
            }
            swap(numbers, masterCounter, curMin);
        }

        return numbers;
    }

}
