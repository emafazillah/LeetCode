package com.leetcode.algorithms.easy.string;

import java.util.Scanner;

public class BuddyStrings {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String A = scanner.next();
		String B = scanner.next();
		
		// Print output
		System.out.print(buddyStrings(A, B));
		
		scanner.close();
	}
	
	static boolean buddyStrings(String A, String B) {
		char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
		
		if (charA.length != charB.length) {
			return false;	
		} else if (A.equals(B)){
			for (int i = 0; i < charA.length; i++) {
				for (int j = i + 1; j < charA.length; j++) {
					if (charA[i] == charA[j]) {
						return true;
					}
				}
			}
			
			return false;
		} else {
			int countSwap = 0;
			
			for (int i = 0; i < charA.length; i++) {
				if (charA[i] != charB[i] && countSwap == 0) {
					for (int j = i + 1; j < charA.length; j++) {
						if (charA[j] == charB[i]) {
							char temp = charA[j];
							charA[j] = charA[i];
							charA[i] = temp;
							break;
						}
					}
					++countSwap;
				} else if (charA[i] != charB[i] && countSwap >= 1) {
					return false;
				}
			}
			
			return true;
		}
    }

}
