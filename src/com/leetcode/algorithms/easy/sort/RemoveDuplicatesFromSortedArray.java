package com.leetcode.algorithms.easy.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
	
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
		for(int i = 0; i < size; i++) {
			nums[i] = Integer.parseInt(inputs.get(i));
		}
		
		int output = removeDuplicates(nums);
		
		System.out.println(output);
		
		scanner.close();
	}
	
	private static int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0; 
        int count = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i - 1] != nums[i]) {
                nums[count] = nums[i];
                ++count;
            }
		}
        return count;
    }

}
