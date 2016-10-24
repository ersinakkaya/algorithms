package com.pramp.interviews;

public class SpiralMatrix{
   public static void printSpiral(int[][] matrix){
      int width = matrix[0].length;
      int height = matrix.length;
      int top = 0;
      int bottom = height - 1;
      int left = 0;
      int right = width -1;

      while(left <= right && top <= bottom){
//       System.out.println("top =" + top);
//       System.out.println("left =" + left);
//       System.out.println("right =" + right);
//       System.out.println("bottom =" + bottom);
         //print top -> left to right first
         for(int i = left; i <= right; i++){
            System.out.println(matrix[top][i]);
         }
         top++;
         
         
         //print right -> top to bottom
         for(int i = top; i <= bottom; i++){
            System.out.println(matrix[i][right]);
         }
         right--;

         //print bottom -> right to left
         for(int i = right; i >= left; i--){
            System.out.println(matrix[bottom][i]);
         }
         bottom--;
//
//       //print left -> bottom to top
         for(int i = bottom; i >= top; i--){
            System.out.println(matrix[i][left]);
         }
         left++;
      }
   }

   public static void main(String[] args){
      int[][] matrix = {{1,2,3,4,5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}};
      printSpiral(matrix);
   }
}
