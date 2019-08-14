package com.leetcode.algorithms.easy.math;

import java.util.Scanner;

public class CountPrimes {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		// Print output
		System.out.println(countPrimes(n));
		
		scanner.close();
	}
	
	static int countPrimes(int n) {
		int countPrimes = 0;
		
        for (int i = 2; i <= n; i++) {
        	boolean isPrime = true;
        	
        	for (int j = 2; j <= i; j++) {
        		if (j != i && i % j == 0) {
        			isPrime = false;
        			break;
        		}
        	}
        	
        	if (isPrime) {
        		++countPrimes;
        	}
        }
		
        return countPrimes;
    }

}
