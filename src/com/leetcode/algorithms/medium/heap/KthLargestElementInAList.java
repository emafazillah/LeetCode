package com.leetcode.algorithms.medium.heap;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class KthLargestElementInAList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int k = scanner.nextInt();
		
		// Print output
		System.out.println(findKthLargest(nums, k));
		
		scanner.close();
	}
	
	static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
    }

}
