package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidMountainArray {
	
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
		
		// Check if array is valid mountain array
		System.out.println(validMountainArray(A));
		
		scanner.close();
	}
	
	public static boolean validMountainArray(int[] A) {
		if(A.length <= 2) {
			return false;
		} else {
			// Define peak point
			int peak = 0;
	        if(A.length % 2 == 0) {
	        	peak = A.length / 2;
	        } else {
	        	peak = A.length / 2 + 1;
	        }
	        
	        for(int i = 0; i < A.length; i++) {
	        	// Left
	        	if(i < peak - 1) {
	        		if(A[i] > A[peak - 1]) {
	    				return false;
	    			}
	        	} 
	        	
	        	// Right
	        	else if(i >= peak && i < A.length) {
	        		// If last point then must lesser than peak value
	        		if(i == A.length - 1) {
	        			if(A[peak - 1] <= A[i]) {
		    				return false;
		    			}
	        		} else {
		        		if(A[peak - 1] < A[i]) {
		    				return false;
		    			}
	        		}
	        	}	
			}
			
			return true;
		}
    }

}
