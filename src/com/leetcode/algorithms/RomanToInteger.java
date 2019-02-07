package com.leetcode.algorithms;

import java.util.Scanner;

public class RomanToInteger {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		
		String input = scanner.next();
		int output = romanToInt(input);
		System.out.println(output);
		
		scanner.close();
	}
	
	private static int romanToInt(String s) {
		char[] charArr = s.toCharArray();
		int result = conversion(Character.toString(charArr[0]));
		int i = 1;
		while(i < charArr.length) {
			String before = Character.toString(charArr[i - 1]);
			String current = Character.toString(charArr[i]);
			if(before.equals("I") && current.equals("V")) {
				result = result - conversion(before) + 4;
			} else if(before.equals("I") && current.equals("X")) {
				result = result - conversion(before) + 9;
			} else if(before.equals("X") && current.equals("L")) {
				result = result - conversion(before) + 40;
			} else if(before.equals("X") && current.equals("C")) {
				result = result - conversion(before) + 90;
			} else if(before.equals("C") && current.equals("D")) {
				result = result - conversion(before) + 400;
			} else if(before.equals("C") && current.equals("M")) {
				result = result - conversion(before) + 900;
			} else {
				result += conversion(current);
			}
			
			++i;
		}
		
		return result;
    }
	
	private static int conversion(String s) {
		switch(s) {
			case "V":
				return 5;
			case "X":
				return 10;
			case "L":
				return 50;
			case "C":
				return 100;
			case "D":
				return 500;
			case "M":
				return 1000;
			default:
				return 1;
		}
	}

}
