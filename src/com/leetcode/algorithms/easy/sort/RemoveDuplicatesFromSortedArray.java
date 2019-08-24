package com.leetcode.algorithms.easy.sort;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class RemoveDuplicatesFromSortedArray {
	
	public static void main(String... args) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int output = removeDuplicates(nums);
		
		// Output
		System.out.println(output);
		
		scanner.close();
	}
	
	private static int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0; 
        int count = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i - 1] != nums[i]) {
                nums[count] = nums[i];
                ++count;
            }
		}
        return count;
    }

}
