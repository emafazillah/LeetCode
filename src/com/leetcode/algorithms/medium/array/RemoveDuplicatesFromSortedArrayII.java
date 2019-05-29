package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArrayII {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		
		// Input
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String s = scanner.next();
			if(s.equals("exit")) {
				break;
			}
			inputs.add(s);
		}
		
		// Transform collection to array
		int size = inputs.size();
		int[] nums = new int[size];
		for(int i = 0; i < size; i++) {
			nums[i] = Integer.parseInt(inputs.get(i));
		}
		
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
