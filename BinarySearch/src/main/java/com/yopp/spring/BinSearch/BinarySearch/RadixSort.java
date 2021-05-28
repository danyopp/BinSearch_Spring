package com.yopp.spring.BinSearch.BinarySearch;

import java.util.Arrays;

//O(kn) where k is number of digits in largest number in array
public class RadixSort implements SortAlgorithm{

     public int[] sort(int[] numbers){
         radixSort(numbers);
        return numbers;
    }

    //implement radix
//        get max digit and call countSort for each digit up to the max number of digits
    private void radixSort(int numbers[]){
        int max = getMax(numbers);
        int n = numbers.length;
        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(numbers, n, exp);
    }

    //get a max value from array - O(n)
    private int getMax(int[] numbers){
         if(numbers.length < 1){
             return 0;
         }
         int max = numbers[0];
         for(int i = 0; i < numbers.length; i++) {
             if(numbers[i] > max) {
                 max = numbers[i];
             }
         }
         return max;
    }

//    Takes array of numbers, length of array n, and a current digit for sorting(1,10,100,1000...)
    private void countSort(int arr[], int length, int curdigit){
         int[] output = new int[length];
         //array used to count the number of occurrences of each digit
         int count[] = new int[10];

         Arrays.fill(count, 0);

//       Count number of occurrances each digit 0-9 has at the specified sort location
//       Store this information in the count array
//       ie sorting 33, 53, 69, for lsb would have two 3 and one 9 digit so array would be 0,0,0,2,0,0,0,0,0,1
         for(int i = 0; i<length; i++) {
             count[(arr[i]/curdigit)%10]++;
         }

        // sum the occurrance of each digit so array now contains the index in which the sorted digit should be placed
        // ie sorting 33, 22, 53, 67 results in 0,0,1,3,3,3,3,4,4,4
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (int i = length - 1; i >= 0; i--) {
            //place at specified position in output while walking down from end of numbers array
            output[count[(arr[i] / curdigit) % 10] - 1] = arr[i];
            //decrement count array at digit that was placed so next number with same digit will be placed to the left of it
            count[(arr[i] / curdigit) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for (int i = 0; i < length; i++)
            arr[i] = output[i];

    }

}
