package com.leetcode.algorithms.easy.binarysearch;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class BinarySearch {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
//		List<Integer> inputs = new ArrayList<>();
//		while(scanner.hasNext()) {
//			String input = scanner.next();
//			if("exit".equals(input)) {
//				break;
//			}
//			inputs.add(Integer.parseInt(input));
//		}
		String[] inputs = InputUtil.inputArr(scanner.next());
		
		// Convert Collections to Arrays
//		int[] nums = new int[inputs.size()];
//		for(int i = 0; i < inputs.size(); i++) {
//			nums[i] = inputs.get(i);
//		}
		int[] nums = InputUtil.integerArr(inputs);
		
		// Output
		System.out.println(search(nums, target));
		
		scanner.close();
	}
	
	public static int search(int[] nums, int target) {
		int mid = nums.length / 2;
		int root = nums[mid];
		if(target > root) {
			for(int i = mid; i < nums.length; i++) {
				if(nums[i] == target) {
					return i;
				}
			}
		} else if(target < root) {
			for(int i = 0; i < mid; i++) {
				if(nums[i] == target) {
					return i;
				}
			}
		} else {
			return mid;
		}
		
		return -1;
    }

}
