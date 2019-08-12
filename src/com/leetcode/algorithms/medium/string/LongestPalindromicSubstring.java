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

	static String longestPalindrome(String s) {
		if (s.length() == 1) {
			return s;
		} else {
			String longestPalindromicString = "";
			
			for (int midPoint = 0; midPoint < s.length(); midPoint++) {
				for (int i = 0; i <= midPoint; i++) {
					String oddLeft = "";
					String oddRight = "";
					String evenLeft = "";
					String evenRight = "";
					
					if (midPoint - i >= 0 && midPoint + 1 + i <= s.length()) {
						oddLeft = s.substring(midPoint - i, midPoint);
						oddRight = s.substring(midPoint + 1, midPoint + 1 + i);
					}
					
					if (midPoint - i >= 0 && midPoint + 2 + i <= s.length()) {
						evenLeft = s.substring(midPoint - i, midPoint + 1);
						evenRight = s.substring(midPoint + 1, midPoint + 2 + i);
					}
					
					boolean isPalindromic = true;
					
					for (int j = 0; j < oddLeft.length(); j++) {
						if (oddLeft.charAt(j) != oddRight.charAt(oddLeft.length() - 1 - j)) {
							isPalindromic = false;
							break;
						}
					}
					
					if (isPalindromic) {
						String palindromicString = oddLeft + s.charAt(midPoint) + oddRight;
						
						if (palindromicString.length() > longestPalindromicString.length()) {
							longestPalindromicString = palindromicString;
						}
					}
					
					isPalindromic = true;
					
					for (int j = 0; j < evenLeft.length(); j++) {
						if (evenLeft.charAt(j) != evenRight.charAt(evenLeft.length() - 1 - j)) {
							isPalindromic = false;
							break;
						}
					}
					
					if (isPalindromic) {
						String palindromicString = evenLeft + evenRight;
						
						if (palindromicString.length() > longestPalindromicString.length()) {
							longestPalindromicString = palindromicString;
						}
					}
				}
			}
			
			return longestPalindromicString;			
		}
	}
}
