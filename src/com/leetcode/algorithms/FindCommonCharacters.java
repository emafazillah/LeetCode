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
		// Reference Map, A[0]
		char[] charA0 = A[0].toCharArray();
		Map<Character, Integer> mapCharA0 = mapping(charA0);
		
		for(int i = 1; i < A.length; i++) {
			// A[i]
			char[] charAi = A[i].toCharArray();
			Map<Character, Integer> mapCharAi = mapping(charAi);
			
			// Compare with reference Map
			for(Map.Entry<Character, Integer> mapA0 : mapCharA0.entrySet()) {
				char key = mapA0.getKey();
				int value = mapA0.getValue();
				if(mapCharAi.containsKey(key)) {
					// Update value of key of reference Map if value of key of current Map is less than reference Map
					// Do nothing if value of key of reference Map equal or greater than current Map
					if(value > mapCharAi.get(key)) {
						mapCharA0.put(key, mapCharAi.get(key));
					}
				} else {
					// Update value of key of reference Map with 0
					mapCharA0.put(key, 0);
				}
			}
		}
		
		// Output
		List<String> result = new ArrayList<>();
		for(Map.Entry<Character, Integer> map : mapCharA0.entrySet()) {
			char key = map.getKey();
			int value = map.getValue();
			for(int i = 0; i < value; i++) {
				result.add(Character.toString(key));
			}
		}
		
		return result;
    }
	
	private static Map<Character, Integer> mapping(char[] chars) {
		Map<Character, Integer> mapResult = new HashMap<>();
		for(char c : chars) {
			int count = 1;
			if(mapResult.containsKey(c)) {
				count = mapResult.get(c);
				++count;
				mapResult.remove(c);
			}
			mapResult.put(c, count);
		}
		
		return mapResult;
	}

}
