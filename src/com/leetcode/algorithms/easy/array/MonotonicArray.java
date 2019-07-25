package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonotonicArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			inputs.add(Integer.parseInt(input));
		}
		
		// Collection to Array
		int[] A = new int[inputs.size()];
		for(int i = 0; i < A.length; i++) {
			A[i] = inputs.get(i);
		}
		
		// Check if array is monotonic
		System.out.println(isMonotonic(A));
		
		scanner.close();
	}
	
	public static boolean isMonotonic(int[] A) {
		if(A.length == 0) {
			return true;
		} else {
			if(A.length == 1) {
				return true;
			} else {
				int countMonotonicOrder = 0;
				
				// Check for ascending order
				for(int i = 0; i < A.length - 1; i++) {
					if(A[i + 1] >= A[i]) {
						++countMonotonicOrder;
					}
				}
				
				if(countMonotonicOrder == A.length - 1) {
					return true;
				}
				
				countMonotonicOrder = 0;
				
				// Check for descending order
				for(int i = 1; i < A.length; i++) {
					if(A[i - 1] >= A[i]) {
						++countMonotonicOrder;
					}
				}
				
				if(countMonotonicOrder == A.length - 1) {
					return true;
				}
				
				return false;
			}
		}
    }

}
