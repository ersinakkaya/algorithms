package com.pramp.interviews;

public class ArrayOfArrays {
   public static int[] answer(int[] array){
      int[] results = new int[array.length];
      
      int left[] = new int[array.length];
      int right[] = new int[array.length];
      for(int i = 1; i < array.length; i++){
         left[i] = array[i-1] * left[i-1];
      }
      
      for(int j = array.length - 2; j > 0; j--){
         right[j] = array[j+1] * right[j+1];
      }
      
      for(int i = 0; i < array.length; i++){
         results[i] = left[i] * right[i];
      }
      
      return results;
   }
   
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }
}
