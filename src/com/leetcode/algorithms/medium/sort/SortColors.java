package com.leetcode.algorithms.medium.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SortColors {
	
	private static boolean isSorted;
	
	static void sortColors(int[] nums) {
		if (nums.length <= 1) {
			System.out.println(Arrays.toString(nums));
		}
		
		isSorted = false;
		
		while(!isSorted) {
			nums = sortList(nums);
		}
		
		System.out.println(Arrays.toString(nums));
    }
	
	static int[] sortList(int[] list) {
		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) {
				int temp = list[i + 1];
				list[i + 1] = list[i];
				list[i] = temp;
				return list;
			}
		}
		
		isSorted = true;
		
		return list;
	}	
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Output
		sortColors(nums);
		
		scanner.close();
	}

}
