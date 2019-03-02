package com.leetcode.algorithms;

import java.util.Scanner;

public class ToLowerCase {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		
		System.out.println(toLowerCase(input));
		
		scanner.close();
	}
	
	public static String toLowerCase(String str) {
		String result = "";
		
		char[] strList = str.toCharArray();
		
		for(int i = 0; i < strList.length; i++) {
			result = result + Character.toLowerCase(strList[i]);
		}
		
		return result;
    }

}
