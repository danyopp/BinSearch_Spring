package com.yopp.spring.BinSearch.BinarySearch;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinarySearchApplication {

	public static void main(String[] args) {

		SpringApplication.run(BinarySearchApplication.class, args);

		int[] array = {9,8,3,6,7,2,1,4,5, 44, 38, 58, 58, 58, 383, 12, 50};
		int len = array.length;

		printArray(array, 0, len);

		SortAlgorithm i = new RadixSort();
		array = i.sort(array);

		printArray(array, 0, len);

	}

	private static void printArray(int[] arr, int low, int high){
		System.out.print("Array: ");
		for(int i = low; i < high; i++){
			System.out.print(arr[i]+ ", ");
		}
	}

}
