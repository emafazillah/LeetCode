package com.leetcode.algorithms.medium.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SingleElementInASortedArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int result = singleNonDuplicate(nums);
		
		// Print output
		System.out.println(result);
		
		scanner.close();
	}
	
	private static int singleNonDuplicate(int[] nums) {
		// Store number of array and number's count
		Map<Integer, Integer> map = new HashMap<>();
		map.put(nums[0], 1);
        int count = 1;
		for(int i = 1; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		map.remove(nums[i]);
        		++count;
        	} else {
        		count = 1;
        	}
        	
        	map.put(nums[i], count);
        }
		
		// Get single element
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return 0;
    }

}
