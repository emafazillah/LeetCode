package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RotateArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String s = scanner.next();
			if(s.equals("exit")) {
				break;
			}
			inputs.add(s);
		}
		
		// List to array
		int[] nums = new int[inputs.size() - 1];
		int i = 0;
		while(i < inputs.size() - 1) {
			nums[i] = Integer.parseInt(inputs.get(i));
			++i;
		}
		
		// k step
		int k = Integer.parseInt(inputs.get(inputs.size() - 1));
		
		// Rotate
		rotate(nums, k);
		
		scanner.close();
	}
	
	private static void rotate(int[] nums, int k) {
        int i = 1;
        while(i < k + 1) {
        	int j = nums.length - 1;
        	
        	// Store the-num.length - i item
        	int temp = nums[j];
        	
        	// Start rotate
        	while(j > -1) {
        		if(j == 0) {
        			nums[j] = temp;
        		} else {
        			nums[j] = nums[j -1];
        		}
        		
        		--j;
        	}
        	
        	++i;
        }
        
        // Print result
        System.out.println(Arrays.toString(nums));
    }

}
