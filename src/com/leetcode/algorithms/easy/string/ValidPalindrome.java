package com.leetcode.algorithms.easy.string;

import java.util.Scanner;

public class ValidPalindrome {
	
	public static void main (String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		
		// Print output
		System.out.println(isPalindrome(scanner.next()));
		
		scanner.close();
	}
	
	static boolean isPalindrome(String s) {
		if (s.length() <= 1) {
            return true;
        }
        
        String updated = s.replaceAll("[^A-Za-z0-9]", "");
        char[] arr = updated.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
        	String left = Character.toString(arr[i]);
        	String right = Character.toString(arr[arr.length - 1 - i]);
        	if (!left.equalsIgnoreCase(right)) {
        		return false;
        	}
        }
        
        return true;
    }

}
