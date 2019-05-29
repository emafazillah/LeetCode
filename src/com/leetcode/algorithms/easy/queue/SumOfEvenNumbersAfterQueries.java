package com.leetcode.algorithms.easy.queue;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
	public static void main(String...strings) {
		int[] A = {1, 2, 3, 4};
		int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
		
		System.out.println(Arrays.toString(sumEvenAfterQueries(A, queries)));
	}
	
	public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        
		for(int i = 0; i < queries.length; i++) {
			int value = queries[i][0];
			int index = queries[i][1];
			
			// Adding value to A[index]
			A[index] += value;
			
			// Get sum of even value
			int sum = 0;
			for(int j = 0; j < A.length; j++) {
				if(A[j] % 2 == 0) {
					sum += A[j];
				}
			}
			
			result[i] = sum;
		}
		
		return result;
    }

}
