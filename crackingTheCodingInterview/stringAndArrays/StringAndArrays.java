package cracking.the.coding.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StringAndArrays {
	
	public static boolean hasDuplicateCharacter(String word){
		
		boolean[] charsUsed = new boolean[128]; 
		for(int i = 0; i < word.length(); i++){
			char character = word.charAt(i);
			if(charsUsed[(int)character] == true){
				System.out.println("character:" + character + " has duplicate value! exiting.");
				return true;
			}
			else{
				charsUsed[(int)character] = true;
			}
		}
		return false;
	}
	
	public static boolean isPermutation(String word1, String word2){
		if(word1.length() != word2.length()){
			return false;
		}
		
		for(int i = 0; i < word1.length(); i++){
			System.out.println("index:" + i);
			char character = word1.charAt(i);
			System.out.println("character:" + character);
			int index = word2.indexOf(character);
			if(index != -1){
				System.out.println("index found at:" + index);
				word2 = word2.substring(0, index) + word2.substring(index + 1);
				System.out.println("remaining:" + word2);
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public static String URLify(String input){
		char[] characters = input.toCharArray();
		boolean startConverting = false;
		StringBuilder builder = new StringBuilder(); 
		for(int i = characters.length - 1; i > - 1; i--){
			if(characters[i] == ' '){
				if(startConverting){
					builder.append("02%");
				}
			}
			else{
				startConverting = true;
				builder.append(characters[i]);
			}
		}
		return builder.reverse().toString(); 
	}
	
	public static boolean palindromePermutation(String input){
		input = input.replace(" ", "").toLowerCase();
		int[] data = new int[128];
		//all characters has to present at least once
		for(int i = 0; i<input.length(); i++){
			data[(int)input.charAt(i)]++;
		}
		
		boolean isEven = (input.length() % 2 == 0)? true: false;
		System.out.println("isEven:" + isEven);
		int singleCount = 0;
		for(int num : data){
			if(num%2 != 0){
				 if(isEven){
					 return false;
				 }
				 else{
					 if(singleCount > 0){
							return false;
						}
						singleCount++;
				 }
			}
		}
		return true;
	}
	
	public static boolean oneAway(String input, String edited){
		int editCount = 0;
		for(char character : input.toCharArray()){
			//if the character doesn't exist
			if(edited.indexOf(character) == -1){
				if(editCount > 0){
					return false;
				}
				editCount++;
			}
		}
		if(edited.length() < input.length() - 1 ) return false;
		return true;
	}
	
	public static String stringCompression(String input){
		Character previous = Character.MIN_VALUE;
		int repeatStartIndex = -1;
		int repeatCounter = 0;
		int index = 0;
		HashMap<Integer, Integer> replacePositions = new HashMap<Integer, Integer>();
		for(Character character : input.toCharArray()){
			if(!character.equals(previous) || (index == input.length()-1)){
				if(repeatCounter > 0){
					replacePositions.put(repeatStartIndex, repeatCounter);
					repeatCounter = 0;
				}
			}
			else{
				if(repeatCounter == 0)
					repeatStartIndex = index;
				repeatCounter++;
			}
			
			previous = character;
			index++;
		}
		
		Iterator it = replacePositions.entrySet().iterator();
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + ": " + pair.getValue());
	        if(first == true){
	        	builder.append(input.substring(0, (int) pair.getKey() - 1));
	        	first = false;
	        }
	        builder.append(input.charAt((int)pair.getKey()));
        	builder.append(pair.getValue());
		}
		
		return builder.toString();
	}
	
	public static String stringCompressionOriginal(String str){
		String compressedString = "";
		int countConsecutive = 0;
		
		for(int i = 0; i < str.length(); i++){
			countConsecutive++;
			/*if next character is different than current, append this char to result.*/
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressedString += "" + str.charAt(i) + countConsecutive;
				countConsecutive = 0;
			}
		}
		return compressedString.length() < str.length()? compressedString : str;
	}
	
	//rotate an image represented by an NxN matrix, where each pixel in the image is 4 bytes. rotate the image by 90 degrees.
	public static boolean rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for(int layer = 0; layer < n / 2; layer++){
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first; i < last; i++){
				int offset = i - first;
				//save top
				int top = matrix[first][i];
				
				//left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				//bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				//right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				//top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
		return true;
	}
	
	
	public static boolean zeroMatrix(int[][] matrix){
		int[][] zeroIndices = new int[matrix.length][matrix[0].length];
		for(int i = 0; i < matrix.length; i++){
			//check rows first
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] == 0){
					//mark all the i row and j column as 0
					zeroIndices[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < zeroIndices.length; i++){
			for(int j = 0; j < zeroIndices[i].length; j++){
				if(zeroIndices[i][j] == 1){
					markEntireRowAsZero(matrix, i);
					martEntireColumnAsZero(matrix, j);
				}
			}
		}
		
		return false;
	}
	
	public static void markEntireRowAsZero(int[][] matrix, int row){
		for(int j = 0; j < matrix[0].length; j++){
			matrix[row][j] = 0;
		}
	}
	
	public static void martEntireColumnAsZero(int[][] matrix, int column){
		for(int i = 0; i < matrix.length; i++){
				matrix[i][column] = 0;
		}
	}
	
	public static boolean isSubstring(String s1, String s2){
		if(s1.indexOf(s2) == -1){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void main(String args[]){
		//hasDuplicateCharacter("abcdefghabc");
		//boolean isPermutation = isPermutation("bcbea", "bbcae");
		//String url = URLify("Mr John Smith   ");
		//boolean isPalindrome = palindromePermutation("Tact Coa");
		//boolean oneAway = oneAway("pale", "bake");
		//String compressed = stringCompression("aaabbccccddd");
		//String compressed = stringCompressionOriginal("aaabbccccddd");
		//int[][] matrix = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
		//rotate(matrix);
		
	}
}
