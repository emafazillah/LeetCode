package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// First attempt

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
		
		// Get max amount of money even house number, even
		// Get max amount of money odd house number, odd
		int even = 0;
		int odd = 0;
		for(int i = 0; i < length; i++) {
			if(i % 2 == 0) {
				even += nums[i];
			} else {
				odd += nums[i];
			}
		}
		
		if(even >= odd) {
			return even; 
		} else {
			return odd;
		}
    }

}
