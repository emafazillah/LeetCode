package com.leetcode.algorithms.easy.dynamicprogramming;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class MaximumSubarray {
	
	static int maxSubArray(int[] nums) {
		int maxCount = nums[0];
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			count += nums[i];
			
			if (count <= 0) {
				maxCount = Math.max(count, maxCount);
				count = 0;
				continue;
			}
			
			if (count > maxCount) {
				maxCount = count; 
			}
		}
        return maxCount;
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
