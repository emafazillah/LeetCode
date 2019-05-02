package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoveZeroes {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("q".equals(input)) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection to Array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(inputs.get(i));
		}
		
		// Output
		moveZeroes(nums);
		
		scanner.close();
	}
	
	public static void moveZeroes(int[] nums) {
		int length = nums.length;
		int i = 0;
		int index = 0;
		int trailingZeroIndex = length - 1; // Initiate trailing zero index
		boolean isAllZeroes = false;
		
		while(i < length) {
			// Check if not equals '0' then update index 'i'
			if(nums[i] == 0) {
				if(i >= trailingZeroIndex) {
					++i;
				} else {
					// Update current trailing zero index
					while((nums[trailingZeroIndex - index] == 0) && (trailingZeroIndex - index > 0)) {
						if(trailingZeroIndex - index > 0) {
							++index;
						} else {
							// The whole array are zeroes
							isAllZeroes = true;
							break;
						}
					}
					if(isAllZeroes) {
						break;
					}
					trailingZeroIndex -= index;
					
					// Loop until '0' reaching trailing zero index
					int j = i;
					while(j < trailingZeroIndex) {
						int temp = nums[j];
						nums[j] = nums[j + 1];
						nums[j + 1] = temp;
						++j;
					}
				}
			} else {
				++i;
			}
		}
		
		// Print output
		System.out.println(Arrays.toString(nums));
    }

}
