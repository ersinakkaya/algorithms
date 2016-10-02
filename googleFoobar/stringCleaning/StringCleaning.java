package com.google.challenges;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StringCleaning {
	private static String answer(String chunk, String word) {
		Set<String> seen = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();

		String finalResult = chunk;

		queue.add(chunk);

		while (!queue.isEmpty()) {
			String value = queue.remove();
			int fromIndex = 0;
			while (value.indexOf(word, fromIndex) != -1) {
				int index = value.indexOf(word, fromIndex);
				String remaining = value.substring(0, index)
						+ value.substring(index + word.length());
				fromIndex++;
				if (remaining.length() == finalResult.length()) {
					if (remaining.compareTo(finalResult) < 0)
						finalResult = remaining;
				} else if (remaining.length() < finalResult.length())
					finalResult = remaining;
				seen.add(remaining);
				queue.add(remaining);
			}

		}
		return finalResult;
	}
	
	public static void main(String[] args) {
		String chunk = "lololololo";
		String word = "lol";
		String output = answer(chunk, word);
		
		System.out.println("result: " + output);
	}

}
