package com.leetcode.algorithms.easy.math;

import java.util.Scanner;

public class ValidPerfectSquare {

	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(isPerfectSquare(num));
		scanner.close();
	}
	
	public static boolean isPerfectSquare(int num) {
		if(num == 1) {
			return true;
		}
		
		long left = 1;
		long right = num / 2;
		while(left <= right) {
			long mid = left + (right - left) / 2;
			if (num == mid * mid) {
				return true;
			} else if(num > mid * mid) {
				left = mid + 1;
            } else {
                right = mid - 1;
            }
		}
		
		return false;
    }
	
}
