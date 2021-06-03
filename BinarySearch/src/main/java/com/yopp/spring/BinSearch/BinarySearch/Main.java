package com.yopp.spring.BinSearch.BinarySearch;

import org.springframework.boot.SpringApplication;

public class Main {
    public static void main(String[] args) {

        SpringApplication.run(BinarySearchApplication.class, args);

        int[] array = {9,8,3,6,7,2,1,4,5, 44, 38, 58, 58, 58, 383, 12, 50};
        int searchVal = 33;
        SortAlgorithm algo = new HeapSort();

        BinarySearchApplication i = new BinarySearchApplication(algo);
        int result =  i.search(array, searchVal );
        System.out.println("Result: " + result);
    }

}
