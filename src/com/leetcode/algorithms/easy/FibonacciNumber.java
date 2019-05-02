package com.leetcode.algorithms.easy;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciNumber {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		System.out.println(fib(N));
		
		scanner.close();
	}
	
	public static int fib(int N) {
		// Fibonacci, (FN) = (FN-1) + (FN-2)
		BigInteger fn = new BigInteger("0");
		BigInteger fnminus1 = new BigInteger("0");
		BigInteger fnminus2 = new BigInteger("1");
		
		for(int i = 0; i < N; i++) {
			//System.out.println("fnminus1: " + fnminus1);
			//System.out.println("fnminus2: " + fnminus2);
			
			fn = fnminus1.add(fnminus2);
			fnminus2 = fnminus1;
			fnminus1 = fn;
			
			//System.out.println("fn: " + fn);
		}
		
		return fn.intValue();
    }

}
