package com.google.challenges;

import java.util.Arrays; 
import java.util.HashSet; 
import java.util.Set; 

public class SpySnippets {
	
	public static String answer(String document, String[] searchTerms){
		String[] words = document.split("\\s+");
		if(words.length < 1 || words.length > 500){
			throw new IllegalArgumentException("words in the document cannot be less than 1 more than 500");
		}
		
		if(searchTerms.length < 1 || searchTerms.length > 100){
			throw new IllegalArgumentException("no of words in the searchTerm cannot be less than 1 more than 100");
		}
		
		Set<String> searchSet = new HashSet<String>(Arrays.asList(searchTerms));
		Set<String> foundWords = new HashSet<String>();
		int startPos = -1;
		int currentPos = 0;
		int smallestSnippetSize = words.length + 1;
		int smallestStartPos = 0;
		while(true){
			if(currentPos == words.length){
				break;
			}
			
			String word = words[currentPos];
			if(word.length() > 10){
				throw new IllegalArgumentException("A word in the document cannot be longer than 10 characters");
			}
			
			if(searchSet.contains(word)){
				if(foundWords.size() == 0){
					startPos = currentPos;
				}
				
				foundWords.add(word);
				
				if(foundWords.size() == searchTerms.length){
					int end = currentPos;
					int size = end - startPos + 1;
					if(size < smallestSnippetSize){
						smallestSnippetSize = size;
						smallestStartPos = startPos;
					}
					foundWords.clear();
					currentPos = startPos;
				}
			}
			
			currentPos++;
		}
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < smallestSnippetSize; i++){
			if(i > 0){
				builder.append(" ");
			}
			builder.append(words[smallestStartPos + i]);
		}
		return builder.toString();
		
	}
	
	public static void main(String[] args) {
		String document = "e j a b c d a";
		String[] searchTerms = { "a", "c", "d" };
		
		String snippet = answer(document, searchTerms);
		
		System.out.println("result: " + snippet);
	}
}
