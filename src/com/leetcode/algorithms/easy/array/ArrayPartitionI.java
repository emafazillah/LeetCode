package com.leetcode.algorithms.easy.array;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class ArrayPartitionI {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		System.out.println(arrayPairSum(nums));
		
		scanner.close();
	}
	
	public static int arrayPairSum(int[] nums) {
        int result = 0;
        
        // Sort nums
        Arrays.sort(nums);
        
        // Find max of sum of min of pairs
        int n = nums.length;
        for(int i = 0; i < n; i+=2) {
        	int value1 = nums[i];
        	int value2 = nums[i + 1];
        	result += Math.min(value1, value2);
        }
		
		return result;
    }

}
