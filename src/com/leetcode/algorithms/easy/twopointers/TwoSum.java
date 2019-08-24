package com.leetcode.algorithms.easy.twopointers;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class TwoSum {
	
	public static void main(String... args) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int target = scanner.nextInt();
		
		int[] result = twoSum(nums, target);
		
		// Print output
		System.out.print(Arrays.toString(result));;
		
		scanner.close();
	}
	
	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		
		for(int i = 0; i < nums.length; i++) {
			int no1 = nums[i];
			for(int j = 0; j < nums.length; j++) {
				if(j != i) {
					int no2 = nums[j];
					int check = no1 + no2;
					if (check == target) {
						result[0] = i;
						result[1] = j;
						break;
					}
				}
			}
			
			if(result[0] + result[1] != 0) {
				break;
			}
		}
		
		return result;
    }

}
