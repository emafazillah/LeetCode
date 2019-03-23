package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindAllNumbersDisappearedInAnArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			int input = scanner.nextInt();
			if(input == 0) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection to Array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = inputs.get(i);
		}
		
		// Print output
		List<Integer> listOutput = findDisappearedNumbers(nums);
		Integer[] outputs = listOutput.toArray(new Integer[listOutput.size()]);
		System.out.println(Arrays.toString(outputs));
		
		scanner.close();
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> disappearedNumber = new ArrayList<>();
		int length = nums.length;
		
		// For nums.length is equal 0
		if(length == 0) {
			return new ArrayList<>();
		}
		
        // Count disappeared number
		for(int i = 1; i <= length; i++) {
			int j = 0;
			while(j < length) {
				if(i == nums[j]) {
					break;
				}
				++j;
			}
			
			if(j == length) {
				disappearedNumber.add(i);
			}
		}
		
		return disappearedNumber;
    }

}
