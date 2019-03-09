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
        // Array for save count
		char[] charA0 = A[0].toCharArray();
		int[] countCharA0 = new int[charA0.length];
		
		// Counting
		for(int i = 1; i < A.length; i++) {
			char[] charAi = A[i].toCharArray();
			for(int j = 0; j < charA0.length; j++) {
				String stringToCompare = Character.toString(charA0[j]);
				for(int k = 0; k < charAi.length; k++) {
					if(stringToCompare.equals(Character.toString(charAi[k]))) {
						++countCharA0[j];
						break;
					}
				}
			}
		}
		
		// Output
		List<String> result = new ArrayList<>();
		for(int i = 0; i < charA0.length; i++) {
			if(countCharA0[i] >= (A.length - 1)) {
				result.add(Character.toString(charA0[i]));
			}
		}
		
		return result;
    }

}
