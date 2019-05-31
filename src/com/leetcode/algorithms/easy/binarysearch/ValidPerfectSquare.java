package com.leetcode.algorithms.easy.binarysearch;

import java.util.Scanner;

public class ValidPerfectSquare {

	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(isPerfectSquare(num));
		scanner.close();
	}
	
	public static boolean isPerfectSquare(int num) {
		int perfectSquare = 1;
		int count = 1;
		while(perfectSquare <= num) {
			if(perfectSquare / num == 1) {
				break;
			}
			perfectSquare = count * count;
			++count;
		}
		
		if(perfectSquare == num) {
			return true;
		} else {
			return false;
		}
    }
}
