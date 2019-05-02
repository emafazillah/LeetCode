package com.leetcode.algorithms.easy;

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		String t = scanner.next();
		
		// Output
		System.out.println(isAnagram(s, t));
		
		scanner.close();
	}
	
	public static boolean isAnagram(String s, String t) {
		// Check length. s length must equal t length
		if(s.length() != t.length()) {
			return false;
		}
		
		// Sort s
		char[] charS = s.toCharArray();
        Arrays.sort(charS);
        
        // Update s
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charS.length; i++) {
        	sb.append(Character.toString(charS[i]));
        }
        
        // Sort t
        char[] charT = t.toCharArray();
        Arrays.sort(charT);
        
        // Update t
        StringBuilder tb = new StringBuilder();
        for(int i = 0; i < charT.length; i++) {
        	tb.append(Character.toString(charT[i]));
        }
        
        // Check s equal t
        if((sb.toString()).equals(tb.toString())) {
        	return true;
        } else {
        	return false;
        }
    }

}
