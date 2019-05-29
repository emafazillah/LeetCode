package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayPartitionI {
	
	public static void main(String...strings) {
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
		
		System.out.println(arrayPairSum(nums));
		
		scanner.close();
	}
	
	public static int arrayPairSum(int[] nums) {
        int result = 0;
        
        // Sort nums
        Arrays.sort(nums);
        /*
        int countSorted = 0;
        while(countSorted < nums.length - 1) {
        	for(int i = 1; i < nums.length; i++) {
            	if(nums[i - 1] > nums[i]) {
            		int temp = nums[i - 1];
            		nums[i - 1] = nums[i];
            		nums[i] = temp;
            	} else {
            		++countSorted;
            	}
            }
        	
        	if(countSorted != (nums.length - 1)) {
        		countSorted = 0;
        	}
        }
        */
        
        // Find max of sum of min of pairs
        int n = nums.length;
        for(int i = 0; i < n; i+=2) {
        	int value1 = nums[i];
        	int value2 = nums[i + 1];
        	result += Math.min(value1, value2);
        }
		
		return result;
    }

}
