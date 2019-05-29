package com.leetcode.algorithms.easy.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSum {
	
	public static void main(String... args) {
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
