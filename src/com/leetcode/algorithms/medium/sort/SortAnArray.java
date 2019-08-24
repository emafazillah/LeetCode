package com.leetcode.algorithms.medium.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SortAnArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(Arrays.toString(sortArray(nums)));
		
		scanner.close();
	}
	
	public static int[] sortArray(int[] nums) {
		int[] result = nums;
		Arrays.sort(nums);
		return result;
    }

}
