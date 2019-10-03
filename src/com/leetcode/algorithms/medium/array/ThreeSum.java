package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class ThreeSum {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		List<List<Integer>> result = threeSum(nums);
		for (List<Integer> list : result) {
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
		
		scanner.close();
	}
	
	static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> listOfList = new ArrayList<>();
		
		if (nums.length < 3) {
			return listOfList;
		}
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			int firstPointer = i + 1;
			int secondPointer = nums.length - 1;
			
			while (firstPointer < secondPointer) {
				int sum = nums[i] + nums[firstPointer] + nums[secondPointer]; 
				
				if (sum == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[firstPointer]);
					list.add(nums[secondPointer]);
					
					Collections.sort(list);
					
					if (!listOfList.contains(list)) {
						listOfList.add(list);
					}
					
					++firstPointer;
				} else if (sum > 0) {
					--secondPointer;
				} else {
					++firstPointer;
				}
			}
		}
        
        return new ArrayList<List<Integer>>(listOfList);
    }

}
