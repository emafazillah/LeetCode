package com.leetcode.algorithms.easy.hashtable;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SingleNumber {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
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
