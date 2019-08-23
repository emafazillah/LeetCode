package com.leetcode.algorithms.easy.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class OptimisedTwoSum {
	
	public static void main(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		int target = scanner.nextInt();
		
		System.out.println(Arrays.toString(twoSum(nums, target)));
		
		scanner.close();
	}
	
	private static int[] twoSum(int[] nums, int target) throws Exception {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		throw new Exception("No matching target");
    }
	
}
