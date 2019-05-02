package com.leetcode.algorithms.easy;

import java.util.Scanner;

public class JewelsAndStones {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		String J = scanner.next();
		String S = scanner.next();
		
		System.out.print(numJewelsInStones(J, S) );
		
		scanner.close();
	}
	
	public static int numJewelsInStones(String J, String S) {
		char[] arrJ = J.toCharArray();
		
		char[] arrS = S.toCharArray();
		
		int result = 0;
		
		for(int i = 0; i < arrJ.length; i++) {
			for(int j = 0; j < arrS.length; j++) {
				if((Character.toString(arrS[j])).equals(Character.toString(arrJ[i]))) {
					++result;
				}
			}
		}
    
		return result;
    }

}
