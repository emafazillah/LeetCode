package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueMorseCodeWords {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		
		List<String> wordList = new ArrayList<>();
		int count = 0;
		
		while(scanner.hasNext()) {
			String input = scanner.next();
			if(input.equals("exit")) {
				break;
			} else {
				wordList.add(input);
				++count;
			}
		}
		
		String[] words = wordList.toArray(new String[count]);
		
		System.out.println(uniqueMorseRepresentations(words));
		
		scanner.close();
	}
	
	public static int uniqueMorseRepresentations(String[] words) {
		// Result set
		Set<String> resultSet = new HashSet<>();
		
		// Morse code mapping
        Map<String, String> morseCodeMap = new HashMap<>();
		morseCodeMap.put("a", ".-");
		morseCodeMap.put("b", "-...");
		morseCodeMap.put("c", "-.-.");
		morseCodeMap.put("d", "-..");
		morseCodeMap.put("e", ".");
		morseCodeMap.put("f", "..-.");
		morseCodeMap.put("g", "--.");
		morseCodeMap.put("h", "....");
		morseCodeMap.put("i", "..");
		morseCodeMap.put("j", ".---");
		morseCodeMap.put("k", "-.-");
		morseCodeMap.put("l", ".-..");
		morseCodeMap.put("m", "--");
		morseCodeMap.put("n", "-.");
		morseCodeMap.put("o", "---");
		morseCodeMap.put("p", ".--.");
		morseCodeMap.put("q", "--.-");
		morseCodeMap.put("r", ".-.");
		morseCodeMap.put("s", "...");
		morseCodeMap.put("t", "-");
		morseCodeMap.put("u", "..-");
		morseCodeMap.put("v", "...-");
		morseCodeMap.put("w", ".--");
		morseCodeMap.put("x", "-..-");
		morseCodeMap.put("y", "-.--");
		morseCodeMap.put("z", "--..");
		
		// Map to alphabet to morse code
		for(int i = 0; i < words.length; i++) {
			String word = words[i];
			String morseCode = "";
			char[] arrWord = word.toCharArray();
			for(int j = 0; j < arrWord.length; j++) {
				morseCode = morseCode + morseCodeMap.get(Character.toString(arrWord[j]));
			}
			
			resultSet.add(morseCode);
		}
		
		return resultSet.size();
    }

}
