package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortAnArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			inputs.add(Integer.parseInt(input));
		}
		
		// Sort
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = inputs.get(i);
		}
		System.out.println(Arrays.toString(sortArray(nums)));
		
		scanner.close();
	}
	
	public static int[] sortArray(int[] nums) {
		int[] result = nums;
		Arrays.sort(nums);
		return result;
    }

}
