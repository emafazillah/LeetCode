package com.leetcode.algorithms.easy.array;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class NonDecreasingArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Check possibility
		if(checkPossibility(nums)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		scanner.close();
	}
	
	public static boolean checkPossibility(int[] nums) {
		if(nums.length == 0) {
			return true;
		} else {
			if(nums.length == 1) {
				return true;
			} else {
				int countModified = 0;
				for(int i = 0; i < nums.length; i++) {
					if(i == 0) {
						if(nums[i] > nums[i + 1]) {
							if(countModified > 0) {
								return false;
							} else {
								nums[i] = nums[i + 1];
								++countModified;
							}
						}
					} else if(i == nums.length - 1) {
						if(nums[i - 1] > nums[i]) {
							if(countModified > 0) {
								return false;
							} else {
								nums[i - 1] = nums[i];
								++countModified;
							}
						}
					} else {
						if(nums[i] > nums[i + 1]) {
							if(countModified > 0) {
								return false;
							} else {
								if(nums[i - 1] > nums[i + 1]) {
									nums[i + 1] = nums[i];
								} else {
									nums[i] = nums[i - 1];
								}
								++countModified;
							}
						}
					}
				}
				
				return true;
			}
		}
	}

}
