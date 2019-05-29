package com.leetcode.algorithms.easy.bitmanipulation;

import java.util.Scanner;

public class HammingDistance {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		System.out.println(hammingDistance(x, y));
		
		scanner.close();
	}
	
	public static int hammingDistance(int x, int y) {
		String strX = Integer.toBinaryString(x);
		String strY = Integer.toBinaryString(y);
		
		if(strX.length() > strY.length()) {
			strY = addPadding(strY, strX.length());
		} else {
			strX = addPadding(strX, strY.length());
		}
		
		int count = 0;
		
		char[] charXs = strX.toCharArray();
		char[] charYs = strY.toCharArray();
		
		for(int i = 0; i < charXs.length; i++) {
			if(!Character.toString(charYs[i]).equals(Character.toString(charXs[i]))) {
				++count;
			}
		}
		
		return count;
    }
	
	private static String addPadding(String input, int len) {
		int paddingSize = len - input.length();
		
		String paddingZero = "";
		
		for(int i = 0; i < paddingSize; i++) {
			paddingZero = paddingZero + "0";
		}
		
		return paddingZero + input;
	}

}
