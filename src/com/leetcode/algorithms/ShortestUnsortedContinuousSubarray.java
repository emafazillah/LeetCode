package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShortestUnsortedContinuousSubarray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			int input = scanner.nextInt();
			if(input == 0) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection to Array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = inputs.get(i);
		}
		
		// Print output
		System.out.println(findUnsortedSubarray(nums));
		
		scanner.close();
	}
	
	public static int findUnsortedSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i < nums.length; i++) {
        	int previous = nums[i - 1];
        	int current = nums[i];
        	int next = nums[i + 1];
        	
        	if(previous > current) {
        		
        	} else if(previous > next) {
        		
        	} else if(current > next) {
        		
        	}
        }
		
		return map.size();
    }

}
