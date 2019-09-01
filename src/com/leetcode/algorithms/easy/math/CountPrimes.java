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
		if (n < 2) {
            return 0;
        }
        
		int countPrimes = 0;
		
        for (int i = 2; i < n; i++) {
        	if (isPrime(i)) {
        		++countPrimes;
        	}
        }
		
        return countPrimes;
    }
	
	static boolean isPrime(int i) {
		int j = 2;
        while (j < i) {
    		if (i % j == 0) {
    			return false;
    		}
    		
    		if (j * j >= i) {
    			break;
    		}
            
            j++;
    	}
        
        return true;
	}

}
