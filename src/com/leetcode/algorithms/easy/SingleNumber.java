package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SingleNumber {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			int input = scanner.nextInt();
			if(input == -1) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection to Array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = inputs.get(i);
		}
		
		// Output
		System.out.println(singleNumber(nums));
		
		scanner.close();
	}
	
	public static int singleNumber(int[] nums) {
		if(nums.length == 1) {
			return nums[0];
		}
		
        Arrays.sort(nums);
        
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	if(i == 0) {
        		if(nums[i] != nums[i + 1]) {
            		result = nums[i];
            		break;
            	}
        	} else if(i == nums.length - 1) {
        		if(nums[i] != nums[i - 1]) {
        			result = nums[i];
            		break;
        		}
        	} else {
        		if(nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
            		result = nums[i];
            		break;
            	}
        	}
        }
		
		return result;
    }

}
