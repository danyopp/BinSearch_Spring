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

		SortAlgorithm i = new HeapSort();
		array = i.sort(array);

		printArray(array, 0, len);

		int result = binSearch(array, 0, array.length-1, 53);
		System.out.println("Result: " + result);
	}

	private static void printArray(int[] arr, int low, int high){
		System.out.print("Array: ");
		for(int i = low; i < high; i++){
			System.out.print(arr[i]+ ", ");
		}
	}

	private static int binSearch(int[] arr, int startIndex, int endIndex, int searchVal){
//		System.out.println(startIndex + " " + endIndex + " " + ((endIndex-startIndex)/2 + startIndex));
		if(arr[((endIndex-startIndex)/2 + startIndex)] == searchVal) {
			return (endIndex-startIndex)/2 + startIndex;
		}
		else if(startIndex == endIndex){
			return -1;
		}
		else if(arr[((endIndex-startIndex)/2 + startIndex)] > searchVal){
			//search first half of array
			return binSearch(arr, startIndex, ((endIndex-startIndex)/2 + startIndex)-1, searchVal);
			}
		else{
			//search second half off array
			return binSearch(arr, ((endIndex-startIndex)/2 + startIndex)+1, endIndex, searchVal);
		}
	}

}
