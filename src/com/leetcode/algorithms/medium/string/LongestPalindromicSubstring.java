package com.leetcode.algorithms.medium.string;

import java.util.Scanner;

public class LongestPalindromicSubstring {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		// Print output
		System.out.println(longestPalindrome(input));
		
		scanner.close();
	}

	static String longestPalindrome(String input) {
		String longestPalindromicString = "";
		
		for (int midPoint = 1; midPoint < input.length() - 1; midPoint++) {
			for (int i = 1; i <= midPoint; i++) {
				String left = "";
				String right = "";				
				
				if ((midPoint - i > -1) && (midPoint + i < input.length())) {
					if (input.charAt(midPoint) == input.charAt(midPoint + 1)) {
						left = input.substring(midPoint - (i - 1), midPoint + 1);
						right = input.substring(midPoint + 1, midPoint + 1 + i);
					} else {
						left = input.substring(midPoint - i, midPoint);
						right = input.substring(midPoint + 1, midPoint + 1 + i);
					}					
				}
				
				boolean isPalindromic = true;
				
				for (int j = 0; j < left.length(); j++) {
					if (left.charAt(j) != right.charAt(left.length() - 1 - j)) {
						isPalindromic = false;
						break;
					}
				}
				
				if (isPalindromic) {
					String palindromicString = left + input.charAt(midPoint) + right;
					if (input.charAt(midPoint) == input.charAt(midPoint + 1)) {
						palindromicString = left + right;
					}
					
					if (palindromicString.length() > longestPalindromicString.length()) {
						longestPalindromicString = palindromicString;
					}
				}				
			}
		}
		
		return longestPalindromicString;
	}
	
}
