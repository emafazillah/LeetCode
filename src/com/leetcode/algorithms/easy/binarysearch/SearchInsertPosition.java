package com.leetcode.algorithms.easy.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchInsertPosition {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int target = scanner.nextInt();
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			inputs.add(Integer.parseInt(input));
		}
		
		// Output
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = inputs.get(i);
		}
		
		System.out.println(searchInsert(nums, target));
		
		scanner.close();
	}
	
	public static int searchInsert(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == target) {
        		return i;
        	}
        }
		
		return 0;
    }

}
