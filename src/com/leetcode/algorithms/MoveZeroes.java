package com.leetcode.algorithms;

import java.util.ArrayList;
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
		// TODO HOW TO STOP WHEN ALL ZEROES HAVE MOVED TO BACK
		
		int length = nums.length;
		
		int i = 0;
		while(i < length) {
			// Check if not equals '0' then update index 'i'
			if(nums[i] == 0) {
				// Define new trailing zero index
				int index = 0;
				while(nums[(length - 1) - index] == 0) {
					++index;
				}
				
				// Loop until '0' reaching trailing zero index
				int j = i;
				int trailingZeroIndex = length - index;
				while(j < trailingZeroIndex - 1) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					++j;
				}
			} else {
				++i;
			}
		}
    }

}
