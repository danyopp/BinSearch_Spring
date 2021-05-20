package com.yopp.spring.BinSearch.BinarySearch;

public class QuickSort implements SortAlgorithm{

//    Worst Case: O(n^2)
//    Average Case: O(nlog(n))
    public int[] sort(int[] numbers){
        if(numbers == null || numbers.length == 0){return null;}
        int low = 0;
        int high = numbers.length - 1;
        System.out.println("High: " +high);
        quicksort(numbers, low, high);
        return numbers;
    }



    private void quicksort(int[] arr, int low, int high){
        int pivot = high;
        int i = low; int j = high-1;

        while (i <= j){
            System.out.println("i=" + i + " j= " + j);
            //find first item from left "higher-than-pivot"
            while(arr[i] <= arr[pivot] ){
                i++;
                if(i >= pivot){break;}
            }
            //find first item from right "lower-than-pivot"
            while(arr[j] > arr[pivot]){
                j--;
                if(j<i){break;}
            }
//            swap left and right
            if(i < j)
            {
                swap(arr, i, j);
            }
            if(i>=j){break;}
        }
        //swap pivot with last "higher than pivot" number found
        swap(arr, pivot, i);


        //Recursion Call
        if(low < j)
        {quicksort(arr, low, j);}
        if(i < high)
        {quicksort(arr, i, high);}

    }

    private void printArray(int[] arr, int low, int high){
        System.out.println("Array: ");
        for(int i = low; i < high; i++){
            System.out.print(arr[i]+ " ");
        }
    }

}
