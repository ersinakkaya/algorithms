import java.io.*;
import java.util.*;

/*
 * Write a method that prints out a matrix "diagonally"
 * from the bottom-left to the top-right
 * e.g. if given
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * then your method should print out
 * 1
 * 4 2
 * 7 5 3
 * 8 6
 * 9
 */

/*
  i=0
  j=0
  matrix[0][0] -> 1
  
  i=1
  j=0
  matrix[1][0] -> 4
  matrix[0][1] -> 2
  
  i=2;
  j=0;
  matrix[2][0] -> 7
  matrix[1][1] -> 5
  matrix[0][2] -> 3
  
  i=2;
  j=1;
  matrix[2][1]; -> 8
  matrix[1][2]; -> 6

  i=2;
  j=2;
  matrix[2][2] -> 9


  
  
  
*/
class Solution {
  public static void printDiagonalMatrix(int[][] matrix){
    int width = matrix[0].length;
    int height = matrix.length;
    int i = 0;
    int j = 0;
    while(i < height && j < width){
        //i=1,2,3
        int tempJ = j;
        int tempI = i;
        //i= 0
        //j= 0
        //temj = 0;
      //tempi=0;
      //matrix[0][0]
      //j++
      //tempj=1;
      //tempi=0;
        while(tempI >= 0 && tempJ < width){
          System.out.println(matrix[tempI][tempJ]);
          tempJ++;
          tempI--;
        }
      
        
        if(i == height - 1){
          j++;
        } else {
          i++;  
        }
    }
    
  }
  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    printDiagonalMatrix(matrix);
    
  }
}
