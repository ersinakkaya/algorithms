package ClosestPair;

import java.util.*;

public class ClosestPair
{
	public static double[] findClosestPair(double[] points){
		//First we sort the numbers
		Arrays.sort(points);
		int N = points.length;
		
		//assign the biggest number of the array as default closest distance
		double closest = points[N-1];
		double temp;
		double[] pairs;
		pairs = new double[2];
		
		for(int i = 0; i < N-1; i++){
			temp = Math.abs(points[i+1] - points[i]);
			if(temp < closest){
				closest = temp;
				pairs[0] = points[i];
				pairs[1] = points[i+1];
				System.out.println("closest numbers are " + points[i] + " to: " + points[i+1]);
			}
	    }
		return pairs; 
	}

  public static void main(String[] args)
  {
		int totalPoints = 10;
		Random r = new Random();
		double[] points;
		points = new double[10];
		for (int i = 0; i < totalPoints; i++){
			points[i] = r.nextDouble();
			System.out.println(points[i]);
		}
		System.out.println(totalPoints + " random points are generated!");
		double[] closestPair = findClosestPair(points);
		System.out.println("final closest pair is: " + closestPair[0] + ", " + closestPair[1]);
  }
}