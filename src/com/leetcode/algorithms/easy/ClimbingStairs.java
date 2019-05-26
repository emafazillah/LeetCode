package com.leetcode.algorithms.easy;

import java.util.Scanner;

public class ClimbingStairs {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(climbStairs(n));
		scanner.close();
	}
	
	public static int climbStairs(int n) {
		int noOfWay = 0;
		
		for(int step = 1; step <= 2; step++) {
			int count = n;
			
			while(count >= 0) {
				count -= step;
			}
			
			++noOfWay;
		}
		
		return noOfWay;
    }
	
}
