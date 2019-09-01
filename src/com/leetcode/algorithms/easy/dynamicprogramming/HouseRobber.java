package com.leetcode.algorithms.easy.dynamicprogramming;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class HouseRobber {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Output
		System.out.println(rob(nums));
		
		scanner.close();
	}
	
	public static int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		} else if (nums.length == 3) {
			return Math.max(nums[0] + nums[2], nums[1]);
		} else {
			int[] dp = new int[nums.length];
			dp[0] = nums[0];
			dp[1] = nums[1];
			dp[2] = nums[0] + nums[2];
			int max = Math.max(dp[1], dp[2]);
			for (int i = 3; i < dp.length; i++) {
				dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
				max = Math.max(dp[i], max);
			}
			
			return max;
		}
    }

}
