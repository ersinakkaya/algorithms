package com.pramp.interviews;
import java.util.*;

class FindTheDuplicates {
   /*
   [2, 3]
   [1,4,6,9, 15, 20, 23, 25]
   // O(n + m) -> O(m) -> O(n * log m)
   // n = 2
   // m = 256
   // 2^10 = 1024 / 4 = 2^8
   //  2 * 2 * 2 * 2 * 2 * 2 * 2 * 2  ^ 8 == 256
   // O(n+m) = 100005   O(n * log m) = 8 * 2 = 16
  // 2 + 256 = 258
   */
   public ArrayList<Integer> FindTheDuplicates(int[] Arr1, int[] Arr2){
      ArrayList<Integer> result = new ArrayList<Integer>();
      
      for(int i = 0; i < Arr1.length; i++){
         if(binarySearch(Arr1[i], Arr2)){
            result.add(Arr1[i]);
         }
      }
      return result;
   }
   //[0,5] num = 3
   //floor 0 -> 0
   //ceiling  1 -> 5
   //index = 0
   public static boolean binarySearch(int num, int[] Arr2){
      int floor = 0;
      int ceiling = Arr2.length - 1;
      
      while(floor <= ceiling){

          int index = floor + (ceiling - floor) / 2;
         
          if(num > Arr2[index]){
             floor = index + 1;
          }
          else if(num < Arr2[index]){
             ceiling = index - 1;
          }
          else{
             return true;
          }
      }
      
      return false;
   }
}

//1)
// Arr1 int[] n
// Arr2 int[] m
// Space complexity: n * log m
// Time complexity ()
/*
[1,4,6,9, 15, 20]
[21, 22, 14, 15, 18]
// O(n + m)
// Time complexity: n > m Space O(m) or n < m O(n)

//m[0] ->1
//n[0] -> if(n[0] > m[0]) -> n[i] i++
//j 
*/