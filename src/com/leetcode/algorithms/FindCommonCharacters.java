package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindCommonCharacters {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection to Array
		String[] A = new String[inputs.size()];
		for(int i = 0; i < A.length; i++) {
			A[i] = inputs.get(i);
		}
		
		// Output
		List<String> resultList = commonChars(A);
		String[] result = new String[resultList.size()];
		for(int i = 0; i < result.length; i++) {
			result[i] = resultList.get(i);
		}
		
		System.out.println(Arrays.toString(result));
		
		scanner.close();
	}
	
	public static List<String> commonChars(String[] A) {
		// Map for result
		Map<Character, Integer> mapResult = new HashMap<>();
		
		// Compare Map value
		Map<Character, Integer> mapCharA0 = new HashMap<>();
		char[] charA0 = A[0].toCharArray();
		for(char c : charA0) {
			int count = 1;
			if(mapCharA0.containsKey(c)) {
				count = mapCharA0.get(c);
				++count;
				mapCharA0.remove(c);
			}
			mapCharA0.put(c, count);
		}
		
		for(int i = 1; i < A.length; i++) {
			// A[i]
			Map<Character, Integer> mapCharAi = new HashMap<>();
			char[] charAi = A[i].toCharArray();
			for(char c : charAi) {
				int countI = 1;
				if(mapCharAi.containsKey(c)) {
					countI = mapCharAi.get(c);
					++countI;
					mapCharAi.remove(c);
				}
				mapCharAi.put(c, countI);
			}
			
			// Compare
			for(Map.Entry<Character, Integer> mapAi : mapCharAi.entrySet()) {
				char key = mapAi.getKey();
				int value = mapAi.getValue();
				if(mapCharA0.containsKey(key) && mapCharA0.get(key) == value) {
					int count0 = 1;
					if(mapResult.containsKey(key)) {
						count0 = mapResult.get(key);
						++count0;
						mapResult.remove(key);
					}
					mapResult.put(key, count0);
				}
			}
		}
		
		// Output
		List<String> result = new ArrayList<>();
		for(char c : charA0) {
			if(mapResult.containsKey(c) && mapResult.get(c) == A.length - 1) {
				result.add(Character.toString(c));
			}
		}
		
		return result;
    }

}
