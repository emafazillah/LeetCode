package com.leetcode.algorithms;

import java.util.Scanner;

public class SortArrayByParityII {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		
		
		scanner.close();
	}
	
	public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
		
        int countEven = 0;
        int[] even = new int[A.length / 2];
        int countOdd = 0;
        int[] odd = new int[A.length / 2];
        String firstMap = "Even";
        
        // Sort odd or even
        for(int i = 0; i < A.length; i++) {
        	int item = A[i];        	
        	if(item % 2 == 0) {
        		even[countEven] = item;
        		++countEven;
        	} else {
        		if(i == 0) {
        			firstMap = "Odd";
        		}
        		
        		odd[countOdd] = item;
        		++countOdd;
        	}
        }
        
        // Sort by parity
        for(int i = 0; i < result.length; i++) {
        	if("Even".equals(firstMap)) {
        		
        	}
        }
		
        return result;
    }

}
