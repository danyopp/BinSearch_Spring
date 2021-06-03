package com.yopp.spring.BinSearch.BinarySearchImpl;

import org.springframework.stereotype.Component;

@Component
public class HeapSort implements SortAlgorithm{
    public int[] sort(int[] numbers){

        HeapHelper heap = new HeapHelper(numbers);
        for(int j = numbers.length-1; j >= 0; j-- ){
            heap.heapify();
            heap.printHeap();
            numbers[j] = heap.removeTop();
        }
        return numbers;
    }


    private class HeapHelper{
       int[] bTree;
       int rows;
       int length;

       //Constructor to build heapHelper Class
       HeapHelper(int[] numbers){
            //copy array to internal array
            bTree = numbers.clone();
            length = bTree.length;
            countRows();
       }

       //Removes Top element of heap and returns value
       //Then moves last item in heap to replace top element and decreases heap size by one
       int removeTop(){
           swap(0,length-1);
           length--;
           countRows();
           return bTree[length];
       }

       //counts the number of rows in the heap
       void countRows(){
           int i = 0;
           int fullrows = 0;
           while(fullrows<length){
               i++;
               fullrows= fullrows * 2 +1;

           }
           rows = i;
       }

       //converts from bTree to max heap
       void heapify(){
           //get second to last row

           int index = (int) (Math.pow(2, rows-1) - 1) - 1; //additional -1 to adjust form length to array index
           //cycle up from second to last row passing up and children
           for (;index >= 0; index--){
               if((index*2+2) < length && bTree[index] < bTree[(index*2+2)] && bTree[index*2+2]>= bTree[index*2+1]){
                   swap(index, index*2+2);
               }else if((index*2+1) < length && bTree[index] < bTree[(index*2+1)]){
                   swap(index, index*2+1);
               }
           }

       }

        void swap(int index1, int index2){
            int temp = bTree[index1];
            bTree[index1] = bTree[index2];
            bTree[index2] = temp;
        }

        void printHeap(){
            int newRow = 1;
           for(int j = 0; j < length; j++){
               if (j == newRow){
                   System.out.println("");
                   newRow = newRow * 2 + 1;
               }
               System.out.print(bTree[j] + " ");
           }
            System.out.println("\n\n");
        }

    }

}
