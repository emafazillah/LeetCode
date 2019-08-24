package com.leetcode.algorithms.medium.array;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class MinimumSizeSubarraySum {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int s = scanner.nextInt();
		String[] inputs = InputUtil.inputArr(input);
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(minSubArrayLen(s, nums));
		
		scanner.close();
	}
	
	static int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else {
			// Key = count of contiguous subarray
	        int key = 0;
	        
	        for (int i = 0; i < nums.length - 1; i++) {
	        	int count = 1;
	        	int sum = nums[i];
	        	
	        	int j = i + 1;
	        	while (j < nums.length && sum < s) {
	        		sum += nums[j];
	        		++count;
	        		++j;
	        	}
	        	
	        	// Update key
	        	if (count >= 1 && sum >= s) {
	        		if (key == 0 || key > count) {
	        			key = count;
	        		}
	        	}
	        }
	        
	        return key;
		}
    }

}
