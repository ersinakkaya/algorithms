package com.pramp.interviews;
import java.util.HashMap;

public class MergeTwoPackages {
	
	public static int[] sumOfWeight(int limit, int[] arr){
		  int[] result = new int[2];
		  HashMap<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
		  
		  int index = 0;
		  for(int value : arr){
			 arrMap.put(value, arr[index]);
			 if(value < limit){
				 int left = limit - value;
		        if(arrMap.containsKey(left)){
		           result[0] = arr[index];
		           result[1] = arrMap.get(left);
		           return result;
		        }
		     }
			 index++;
		  }
		  return result;
	}
	
	public static void main(String[] args){
		int[] arr = { 2, 3, 5, 7, 1, 3, 4 , 5, 3, 2, 1 };
		int limit = 5;
		int[] resp= sumOfWeight(limit, arr);
		System.out.println("sumOfWeight:" + resp[0] + ":" + resp[1]);
	}
	
}
