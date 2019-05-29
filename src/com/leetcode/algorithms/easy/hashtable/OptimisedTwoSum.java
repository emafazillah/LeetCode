package com.leetcode.algorithms.easy.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OptimisedTwoSum {
	
	public static void main(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String s = scanner.next();
			if(s.equals("exit")) {
				break;
			}
			inputs.add(s);
		}
		
		int size = inputs.size();
		int[] nums = new int[size];
		int target = 0;
		for(int i = 0; i < size; i++) {
			if (i < size - 1) {
				nums[i] = Integer.parseInt(inputs.get(i));
			} else {
				target = Integer.parseInt(inputs.get(i));
			}
		}
		
		String strResult = "";
		int[] result = twoSum(nums, target);
		for(int r : result) {
			strResult += Integer.toString(r) + " ";
		}
		System.out.print(strResult.trim());
		
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
