package com.leetcode.algorithms.easy.binarysearch;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SearchInsertPosition {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		int target = scanner.nextInt();
		
		System.out.println(searchInsert(nums, target));
		
		scanner.close();
	}
	
	public static int searchInsert(int[] nums, int target) {
		int root = nums.length / 2;
		
		if(nums[root] > target) {
			for(int i = 0; i <= root; i++) {
				if(nums[i] == target || nums[i] > target) {
					return i;
				}
			}
		} else if(nums[root] < target) {
			for(int i = root; i < nums.length; i++) {
				if(nums[i] == target || nums[i] > target) {
					return i;
				}
			}
			
			return nums.length;
		} else {
			return root;
		}
		
		return 0;
    }

}
