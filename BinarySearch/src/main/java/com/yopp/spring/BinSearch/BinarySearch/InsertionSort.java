package com.yopp.spring.BinSearch.BinarySearch;

public class InsertionSort implements SortAlgorithm{

    public int[] sort(int[] numbers){
        int length = numbers.length;
        //cycle through each element in array
        for(int index = 1; index < length; index++){
                //value at index in array
                int value = numbers[index];
                int subindex = index - 1;
                //cycle through each index smaller than current index and look for a value greater than the current index
                while(subindex >= 0 && numbers[subindex] > value) {
                    //shift higher number right
                    numbers[subindex + 1] = numbers[subindex];
                    subindex -= 1;
                }
            //place index value in hole left after higher numbers have been shifted right
            numbers[subindex+1] = value;
        }

        return numbers;
    }
}
