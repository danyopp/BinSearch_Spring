package com.yopp.spring.BinSearch.BinarySearch;

//Average Case O(nlogn)
public class MergeSort implements SortAlgorithm {
    public int[] sort(int[] numbers) {
        int size = numbers.length -1;
        sort(numbers, 0, size);
        return numbers;
    }

    private void sort(int[] array, int start, int end) {

        if (start < end) {
            int mid = start + ((end - start) / 2);
            sort(array, start, mid);
            sort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(int[] array, int start, int mid, int end) {
        //Get sizes of two halves
        int lowerSize = mid - start + 1;
        int upperSize = end - mid;

       //create and copy into second array
        int[] Lower = new int[lowerSize];
        int[] Upper = new int[upperSize];
        for (int i = 0; i < lowerSize; i++) {
            Lower[i] = array[start + i];
        }
        for (int i = 0; i < upperSize; i++) {
            Upper[i] = array[mid + 1 + i];
        }

        //Merge copied arrays
        int counterLower = 0, counterUpper = 0;
        int counterArray = start;
        while (counterLower < lowerSize && counterUpper < upperSize) {
            if (Lower[counterLower] <= Upper[counterUpper]) {
                array[counterArray] = Lower[counterLower];
                counterLower++;
                counterArray++;
            } else {
                array[counterArray] = Upper[counterUpper];
                counterUpper++;
                counterArray++;
            }
        }
        while (counterLower < lowerSize) {
            array[counterArray] = Lower[counterLower];
            counterLower++;
            counterArray++;
        }
        while (counterUpper < upperSize) {
            array[counterArray] = Upper[counterUpper];
            counterUpper++;
            counterArray++;
        }

    }


}




