package com.leetcode.algorithms.easy;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		boolean output = isPalindrome(input);
		System.out.println(output);
		
		scanner.close();
	}
	
	private static boolean isPalindrome(int x) {
		int quotient = x;
		int reverse = 0;
		
		while(quotient > 0) {
			int remainder = quotient % 10;
			reverse = reverse * 10 + remainder;
			quotient = quotient / 10;
		}
		
		if (x == reverse) {
			return true;
		} else {
			return false;
		}
    }
	
}
