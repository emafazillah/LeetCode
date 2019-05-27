package com.leetcode.algorithms.easy;

import java.util.Scanner;

public class ClimbingStairs {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int step = scanner.nextInt();
		System.out.println(climbStairs(step));
		scanner.close();
	}
	
	public static int fib(int n) {
		if(n <= 1) {
			return n;
		}
		
		return fib(n - 1) + fib(n - 2);
    }
	
	public static int climbStairs(int n) {
		return fib(n + 1);
    }
	
}
