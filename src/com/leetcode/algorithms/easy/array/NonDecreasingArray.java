package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonDecreasingArray {
	
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
		
		// Collection to Array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = inputs.get(i);
		}
		
		// Check possibility
		if(checkPossibility(nums)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		scanner.close();
	}
	
	public static boolean checkPossibility(int[] nums) {
		if(nums.length == 0) {
			return true;
		} else {
			if(nums.length == 1) {
				return true;
			} else {
				int countModified = 0;
				for(int i = 0; i < nums.length; i++) {
					int iValue = nums[i];
					int start = i + 1;
					if(start < nums.length) {
						for(int j = start; j < nums.length; j++) {
							int jValue = nums[j];
							if(iValue > jValue) {
								if(countModified > 0) {
									return false;
								} else {
									if(jValue - 1 > 0) {
										nums[i] = jValue - 1;
										iValue = nums[i];
										++countModified;
									}
								}
							}
						}
					}
				}
				
				return true;
			}
		}
	}

}
