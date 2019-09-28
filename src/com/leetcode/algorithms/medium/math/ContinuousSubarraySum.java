package com.leetcode.algorithms.medium.math;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class ContinuousSubarraySum {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int k = Integer.parseInt(scanner.next());
		
		// Print output
		System.out.println(checkSubarraySum(nums, k));
		
		scanner.close(); 
	}
	
	static boolean checkSubarraySum(int[] nums, int k) {
		for (int start = 0; start < nums.length; start++) {
        	int check = 0;
        	for (int i = start; i < nums.length; i++) {
        		check += nums[i];
                if (i > start) {
                	if (k != 0) {
            			if (check % k == 0) {
                    		return true;
                    	}
            		} else {
            			if (check == k) {
            				return true;
            			}
            		}
        		}
        	}
        }
        
        return false;
    }

}
