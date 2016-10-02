package com.google.challenges;

import java.util.Arrays;
import java.util.Comparator;

public class NameThatRabbit {
	
	public static String[] answer( String[] names){
		if( names.length < 1 || names.length > 1000){
			throw new IllegalArgumentException("names cannot be less than 1, more than 1000!");
		}
		
		Arrays.sort(names, new NameComparator());
		
		return names;
	}
	
	static class NameComparator implements Comparator<String> { 
        @Override 
        public int compare(String name1, String name2) { 
            int val1 = getScore(name1); 
            int val2 = getScore(name2); 
 
            if (val1 < val2) { 
                return 1; 
            } 
            else if (val1 > val2) { 
                return -1; 
            } 
            else { 
                return -name1.compareTo(name2); 
            } 
        } 
 
        public static int getScore(String name){
    		int score = 0;
    		int nameLength = name.length();
    		
    		if(nameLength < 1 || nameLength > 8){
    			throw new IllegalArgumentException("name length cannot be less than 1 more than 8");
    		}
    		
    		for(int i = 0; i < nameLength; i++){
    			char ch = name.charAt(i);
    			if(Character.isUpperCase(ch)){
    				throw new IllegalArgumentException("a word cannot contain uppercase!");
    			}
    			score = ch - 'a' + 1 + score;
    		}
    		return score;
    	}
    }
	
	public static void main(String[] args) {
		
		String[] names = {"liz", "yi", "ersin", "james", "fatih", "aaa", "ba"};
		
		String[] sortedNames = answer(names);
		
		for(String name : sortedNames){
			System.out.println(name + ": " + NameComparator.getScore(name));
		}
		
	}
}