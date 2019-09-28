package com.leetcode.algorithms.easy.dynamicprogramming;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class MaximumSubarray {
	
	static int maxSubArray(int[] nums) {
		int maxCount = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int count = getMax(nums, i, maxCount);
			if (count > maxCount) {
				maxCount = count; 
			}
		}
        return maxCount;
    }
	
	static int getMax(int[] nums, int start, int max) {
		int length = nums.length - start;
		while (length > 0) {
			int current = 0;
			
			for (int i = start; i < start + length; i++) {
				current += nums[i];
			}
			
			if (current > max) {
				max = current;
			}
			
			--length;
		}
		return max;
	}
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(maxSubArray(nums));
		
		scanner.close(); 
	}

}
