package com.leetcode.algorithms.easy;

import java.util.Scanner;

public class ClimbingStairs {
	
	static Integer[] fn = null;
	
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
		fn = new Integer[n];
		
		if(fn[n - 1] == null) {
			fn[n - 1] = fib(n + 1);
		}
		
		return fn[n - 1];
    }
	
}
