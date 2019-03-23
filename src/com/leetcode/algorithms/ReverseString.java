package com.leetcode.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		reverseString(input.toCharArray());
		
		scanner.close();
	}
	
	public static void reverseString(char[] s) {
        // Sort in reverse order
		int length = s.length;
		int j = 1;
		char temp = 0;
		int middle = length / 2;
		for(int i = 0; i < middle; i++) {
			temp = s[i];
			s[i] = s[length - j];
			s[length - j] = temp;
			++j;
		}
		
		// Print output
		System.out.println(Arrays.toString(s));
    }

}
