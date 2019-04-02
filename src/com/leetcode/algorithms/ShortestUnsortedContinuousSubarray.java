package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
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
		int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	System.out.println("nums[" + i + "]===" + nums[i]);
        	for(int j = 0; j < nums.length; j++) {
	        	if(i != j) {
	        		//System.out.println("nums[" + i + "]===" + nums[i]);
	        		//System.out.println("nums[" + j + "]===" + nums[j]);
	        		if(i == 0) {
	        			if(nums[i] > nums[j]) {
	        				System.out.println("nums[i] > nums[j]");
	        				System.out.println("nums[" + j + "]===" + nums[j]);
			        		++count;
			        		break;
			        	}
	        		} else if(i == nums.length - 1) {
	        			if(nums[i] < nums[j] && i > j) {
	        				System.out.println("nums[i] < nums[j]");
	        				System.out.println("nums[" + j + "]===" + nums[j]);
			        		++count;
			        		break;
			        	}
	        		} else {
	        			if(nums[i] > nums[j] && i < j) {
	        				System.out.println("nums[i] > nums[j]");
	        				System.out.println("nums[" + j + "]===" + nums[j]);
			        		++count;
			        		break;
			        	} else if(nums[i] < nums[j] && i > j) {
			        		System.out.println("nums[i] < nums[j]");
			        		System.out.println("nums[" + j + "]===" + nums[j]);
			        		++count;
			        		break;
			        	}
	        		}
	        	}
	        }
        }
		
		return count;
    }

}
