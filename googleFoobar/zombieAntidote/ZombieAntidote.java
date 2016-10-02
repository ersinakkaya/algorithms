package com.google.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ZombieAntidote {
	public static int answer(int[][] numbers) {
		if(numbers.length < 1 || numbers.length > 100){
			throw new IllegalArgumentException("no of meetings cannot be less than 1 more than 100");
		}
		
		for(int number[] : numbers){
		}
		
		Arrays.sort(numbers, new Comparator<int[]>(){
			@Override
			public int compare(final int[] num1, final int[] num2){
				if(num1[0] < 0 || num1[1] > 1000000 || num1.length > 2){
					throw new IllegalArgumentException("meeting hours cannot be less than 0 more than 1000000 and meeting hours cannot be more than 2");
				}
				
				if(num1[0] == num1[1]){
					throw new IllegalArgumentException("Meeting hour needs to be longer than 0");
				}
				
				if(num1[0] > num2[0]){
					return 1;
				}
				else if(num1[0] < num2[0]){
					return -1;
				}
				else{
					if(num1[1] - num1[0] > num2[1] - num2[0]){
						return 1;
					}
					else if(num1[1] - num1[0] < num2[1] - num2[0]){
						return -1;
					}
					else{
						return 0;
					}
				}
			}
		});
		
		int start = 0;
		int end = 0;
		ArrayList<int[]> meetings = new ArrayList<int[]>();
		for(int[] n : numbers){
			System.out.println(n[0] + ":" + n[1]);
			if(n[0] >= start){
				if(n[0] >= end){
					end = n[1];
					meetings.add(n);
				}
			}
			start = n[0];
		}

		System.out.println("----final----:");
		for(int nm[] : meetings){
			System.out.println( nm[0] + ":" + nm[1]);
		}
		
        return meetings.size();
    }
	
	
	public static void main(String[] args) {
		int numbers[][] = { {0, 2}, {0, 1}, {1, 2}, {2, 4}, {3, 4}, {1, 3}, {0, 1}, {0, 3} };
		int count = answer(numbers);
		System.out.println(count);
	}

}
