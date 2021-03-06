package com.leetcode.algorithms.easy.array;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class ValidMountainArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] A = InputUtil.integerArr(inputs);
		
		// Check if array is valid mountain array
		System.out.println(validMountainArray(A));
		
		scanner.close();
	}
	
	public static boolean validMountainArray(int[] A) {
		if(A.length <= 2) {
			return false;
		} else {
			int peak = 0; // Mountain peak
			int peakPoint = 0; // Mountain peak's point
			int countPeakPoint = 0; // Count mountain peak's point
			
			// Get peak and peak's point
			for(int i = 1; i < A.length - 1; i++) {
				if(A[i] > A[i - 1] && A[i] > A[i + 1] && A[i] > peak) {
					peak = A[i];
					peakPoint = i;
					++countPeakPoint;
				}
				
				if(countPeakPoint > 1) {
					return false;
				}
			}
			
			if(peak == 0) {
				return false;
			}
			
			// Check if valid
			for(int i = 0; i < A.length; i++) {
				if(i < A.length - 1) {
					if(A[i] == A[i + 1]) {
						return false;
					}
				}
				
				// If i is greater than peak's point, then descending order
				if(i < peakPoint) {
					if(A[i] > A[i + 1]) {
						return false;
					}
				}
				// else ascending order
				else if(i > peakPoint) {
					if(A[i] > A[i - 1]) {
						return false;
					}
				}
			}
			
			return true;
		}
    }

}
