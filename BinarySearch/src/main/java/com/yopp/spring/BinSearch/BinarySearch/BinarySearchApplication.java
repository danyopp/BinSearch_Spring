package com.yopp.spring.BinSearch.BinarySearch;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BinarySearchApplication {

	SortAlgorithm algo;

	//loose coupling
	BinarySearchApplication(SortAlgorithm algorithm){
		this.algo = algorithm;
	}

	public int search(int[] arr, int searchVal){
		arr = algo.sort(arr);
		return binSearch(arr, 0, arr.length-1,searchVal);
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
