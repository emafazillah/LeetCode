package com.leetcode.algorithms.medium.array;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class ProductOfArrayExceptSelf {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(Arrays.toString(productExceptSelf(nums)));
		
		scanner.close();
	}
	
	static int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
        	return nums;
        }
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < result.length; i++) {
        	result[i] = 1;
        	for (int j = 0; j < result.length; j++) {
        		if (i != j) {
        			result[i] = result[i] * nums[j];
        		}
        	}
        }
        
        return result;
    }

}
