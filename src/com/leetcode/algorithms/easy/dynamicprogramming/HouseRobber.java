package com.leetcode.algorithms.easy.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HouseRobber {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			int input = scanner.nextInt();
			if(input <= -1) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection into array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = inputs.get(i);
		}
		
		// Output
		System.out.println(rob(nums));
		
		scanner.close();
	}
	
	public static int rob(int[] nums) {
		int length = nums.length;
		
		// For nums length lesser or equal than 2
		if(length == 2) {
			Arrays.sort(nums);
			return nums[1];
		} else if(length == 1) {
			return nums[0];
		} else if(length == 0) {
			return 0;
		}
		
		// Get sums and store it in array
		List<Integer> results = new ArrayList<>();
		int i = 0;
		while(i < length) {
			int diff = 2;
			while(diff < length) {
				int result = 0;
				for(int j = i; j < length; j += diff) {
					result += nums[j];
				}
				results.add(result);
				++diff;
			}
			++i;
		}
		
		// Sort array
		Collections.sort(results);
		
		return results.get(results.size() - 1);
    }

}
