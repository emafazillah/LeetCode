package com.leetcode.algorithms;

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
		BigInteger fn = new BigInteger("0");
		
		for(int i = 0; i < N; i++) {
			BigInteger input = new BigInteger(Integer.toString(N));
			// Fibonacci, (FN) = (FN-1) + (FN-2)
			// BigInteger fn = new BigInteger("0");
			BigInteger fnminus1 = new BigInteger("0");
			BigInteger fnminus2 = new BigInteger("1");
			//long count = 0L;			
			while(fn.compareTo(input) != 1) {
				fn = fnminus1.add(fnminus2);
				fnminus2 = fnminus1;
				fnminus1 = fn;
				//count++;
			}
			//result += Long.toString(count - 1) + " ";
		}
		
		return fn.intValue();
    }

}
