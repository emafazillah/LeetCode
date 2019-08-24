package com.leetcode.algorithms.medium.array;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class RemoveDuplicatesFromSortedArrayII {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		int result = removeDuplicates(nums);
		
		System.out.println(result);
		
		scanner.close();
	}
	
	private static int removeDuplicates(int[] nums) {
		// Store count duplicate
		int count = 1;
		
		int i = 1;
		int result = nums.length;
		while(i < result) {
			// Check if duplicate
			if(nums[i - 1] == nums[i]) {
				++count;
				
				// Check if only allow max 2 duplicate
				if(count > 2) {
					// Move to left
					--result;
					
					int j = i;
					while(j < result) {
						nums[j] = nums[j + 1];
						++j;
					}
					
					// Reset i
					// Reset count
					i = 0;
					count = 1;
				}
			} else {
				// Reset count
				count = 1;
			}
			
			++i;
		}
		
        return result;
    }

}
