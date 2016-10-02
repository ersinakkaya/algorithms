package com.pramp.interviews;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TimePlanner {
	
	public static int[] timePlanner(int dur, int[][] timesA, int[][] timesB){
		int[] result = new int[2];
		Arrays.sort(timesA, new TimeComparator());
		Arrays.sort(timesB, new TimeComparator());
		
		for(int[] n : timesA){
			System.out.println(n[0] + ":" + n[1]);
		}
		
		int a = 0;
		int b = 0;
		int startTime = 0;
		int endTime = 0;
		while(a < timesA.length && b < timesB.length){
			startTime = (timesA[a][0] >= timesB[b][0])? timesA[a][0] : timesB[b][0];
			endTime = (timesA[a][1] < timesB[b][1])? timesA[a][1] : timesB[b][1];
			
			//check if the availability is enough to fill that gap
			if(startTime + dur <= endTime){
				result[0] = startTime;
				result[1] = startTime + dur;
				return result;
			}
			else{
				if (timesA[a][1] < timesB[b][1]){
			         a = a++;
				}else{
			         b = b++;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		int timesA[][] = { {0, 1}, {3, 6}, {7, 8}, {12, 15}  };
		int timesB[][] = { {1, 2}, {5, 6}, {8, 9} };
		int dur = 1;
		int[] availability = timePlanner(dur, timesA, timesB);
		System.out.println("Earliest available meeting:" + availability[0] + ":" + availability[1]);
	}
}

class TimeComparator implements Comparator<int[]> {
    @Override
    public int compare(final int[] num1, final int[] num2){
		if(num1[0] > num2[0]){
			return 1;
		}
		else if(num1[0] < num2[0]){
			return -1;
		}
		else{
			return 0;
		}
	}
}