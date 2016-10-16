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
	
	public static int highestProduct2(int[] arr){
		if(arr.length < 3){
			throw new IllegalArgumentException("Array cannot be less than 3 items");
		}
		int highestProductOfThree = 1;
		int highestProductOf2 = 1;
		int highest = 1;
		int lowestProductOf2 = 1;
		int lowest = 1;
		for(int i = 0; i < arr.length; i++){
			highest= Math.max(arr[i], highest);
			lowest = Math.min(arr[i], lowest);
			highestProductOf2 = Math.max(highest * arr[i], highestProductOf2);
			lowestProductOf2 = Math.min(lowestProductOf2 * arr[i], lowestProductOf2);
			if(highestProductOf2 > lowestProductOf2){
				highestProductOfThree = Math.max(highestProductOf2 * arr[i], highestProductOfThree);
			}
			else{
				highestProductOfThree = Math.max(lowestProductOf2 * arr[i], highestProductOfThree);
			}
		}
		
		return highestProductOfThree;
	}
	public static void main(String[] args){
		int[] data = {-10, -1, 3, 2, -10};
		System.out.println(highestProduct(data));
	}
}
