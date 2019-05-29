package com.leetcode.algorithms.easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DIStringMatch {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		int[] result = diStringMatch(input);
		System.out.println(Arrays.toString(result));
		
		scanner.close();
	}
	
	public static int[] diStringMatch(String S) {
		int len = S.length() + 1;
		
		int countUp = 0; // I
		int countDown = len - 1; // D
		List<Integer> results = new ArrayList<>();
		int[] arr = new int[len];
		
		char[] chars = S.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			if("I".equals(Character.toString(chars[i]))) {
				results.add(countUp);
				arr[i] = countUp;
				++countUp;
			} else {
				results.add(countDown);
				arr[i] = countDown;
				--countDown;
			}
		}
		
		// Check for any miss permutation element
		for(int i = 0; i < len; i++) {
			if(!results.contains(i)) {
				results.add(i);
				arr[len - 1] = i;
			}
		}
		
		return arr;
    }

}
