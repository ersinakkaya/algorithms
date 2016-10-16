package com.interview.cake;

import java.util.Arrays;

public class HighestProductOfThree {

	public static int highestProduct(int[] arr){
		int highest = 0;
		
		Arrays.sort(arr);
		
		int size = arr.length; 
		highest = arr[size-1] * arr[size-2] * arr[size-3];
		int possibleHighest = arr[size-1] * arr[0] * arr[1];
		highest = Math.max(highest, possibleHighest);
		
		return highest;
	}
	
	public static int highestProductOfThree(int[] arr){
		if (arrayOfInts.length < 3) {
	        throw new IllegalArgumentException("Less than 3 items!");
	    }

	    int highest = Math.max(arrayOfInts[0], arrayOfInts[1]);
	    int lowest  = Math.min(arrayOfInts[0], arrayOfInts[1]);
	    int highestProductOfTwo = arrayOfInts[0] * arrayOfInts[1];
	    int lowestProductOf2  = arrayOfInts[0] * arrayOfInts[1];
	    int highestProductOfThree = arrayOfInts[0] * arrayOfInts[1] * arrayOfInts[2];

	    for (int i = 2; i < arrayOfInts.length; i++) {
	        int current = arrayOfInts[i];
	        highestProductOfThree = Math.max(
	        						Math.max(highestProductOfThree, current * highestProductOfTwo),
	        						current * lowestProductOf2
	        					);

	        highestProductOfTwo = Math.max(
	        						Math.max(highestProductOfTwo, current * highest),
	        						current * lowest
	        					);

	        lowestProductOf2 = Math.min(
	        						lowestProductOf2,
	        						current * lowest
	        					);

	        highest = Math.max(highest, current);
	        lowest = Math.min(lowest, current);
	    }

		return highestProductOfThree;
	}
	
	public static void main(String[] args){
		int[] data = {-10, -1, 3, 2, -10};
		System.out.println(highestProductOfThree(data));
	}
}
