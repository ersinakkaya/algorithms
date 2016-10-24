package com.pramp.interviews;
import java.util.*;

public class FindCap {
	   
	   public static int findCap(int[] grants, int budget){
	      //{1, 2, 3, 4} b = 3
	      //partialSums = {1, 3, 6, 10}
	      // 2
	      int total = grants.length;
	      Arrays.sort(grants);
	      
	      int tempSum = 0;
	      int[] partialSums = new int[total];
	      for(int i = 0; i < total; i++){
	         tempSum = tempSum + grants[i];
	         partialSums[i] = tempSum;
	      }
	      if(partialSums[total-1] <= budget){
	         return grants[total-1];
	      }

	      int floor = 0;
	      int ceiling = total - 1;
	      int currentIndex = 0;
	      while(floor < ceiling){
	         currentIndex = (ceiling + floor) / 2;
	         if(cappedSum(currentIndex, grants, partialSums) > budget){
	            if(cappedSum(currentIndex - 1, grants, partialSums) < budget){
	               break;
	            }
	            else{
	               ceiling--;
	            }
	         }
	         else{
	            floor++;
	         }
	         
	      }
	      int cap = (budget - partialSums[currentIndex-1]) / (total - currentIndex);
	      
	      return cap;
	   }
	   
	   public static int cappedSum(int index, int[] grants, int[] partialSums){
	      return partialSums[index - 1] + grants[index] * (grants.length - index);
	   }
	   
	   public static void main(String[] args) {
	      String pramp = "Practice Makes Perfect";
	      System.out.println(pramp);
	   }
	}

	/*
	g = {1, 2 , 3, 4, 90}
	b = 80
	c =?

	// every grant that was planned to be higher than c will now be c dollars.
	// sum is b

	g = { 8 20 20 20 34 } 

	b / n   =  8 < 16 
	b = 80 -? 

	g = { 16 16 16 16 16 } c = 16
	g = { 8  }

	*/





