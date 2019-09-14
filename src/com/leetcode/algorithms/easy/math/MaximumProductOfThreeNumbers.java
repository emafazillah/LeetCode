package com.leetcode.algorithms.easy.math;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class MaximumProductOfThreeNumbers {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(maximumProduct(nums));
		
		scanner.close();
	}
	
	static int maximumProduct(int[] nums) {
        if (nums.length <= 3) {
        	int maxProd = 0;
        	
        	for (int i = 0; i < nums.length; i++) {
        		if (i == 0) {
        			maxProd = nums[i];
        		} else {
        			maxProd *= nums[i];
        		}
        	}
        	
        	return maxProd;
        } else {
        	Arrays.sort(nums);
        	return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }

}
