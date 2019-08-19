package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class FirstAndLastIndices {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		int target = scanner.nextInt();
		
		// Array
//		input = input.replace("[", "");
//		input = input.replace("]", "");
//		String[] inputArr = input.split(",");
//		int[] nums = new int[inputArr.length];
//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = Integer.parseInt(inputArr[i]);
//		}
		
		String[] inputs = InputUtil.inputArr(input);
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(Arrays.toString(getRange(nums, target)));
		
		scanner.close();
	}
	
	static int[] getRange(int[] nums, int target) {
		int[] result = new int[2];
		
		List<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				index.add(i);
			}
		}
		if (index.size() > 1) {
			result[0] = index.get(0);
			result[1] = index.get(index.size() - 1);
		} else if (index.size() == 1) {
			result[0] = index.get(0);
			result[1] = index.get(0);
		} else {
			result[0] = -1;
			result[1] = -1;
		}
		
		return result;
	}

}
