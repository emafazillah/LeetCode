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
		if(nums.length > 0) {
			List<Integer> listOutput = findDisappearedNumbers(nums);
			Integer[] outputs = listOutput.toArray(new Integer[listOutput.size()]);
			System.out.println(Arrays.toString(outputs));
		}
		
		scanner.close();
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		
        // Sort array
		Arrays.sort(nums);
        
		int expected = nums[0]; // Initiate expected next number
		// Count disappear numbers
        List<Integer> disappearedNumber = new ArrayList<>();
        for(int i = 0; i < (nums.length - 1); i++) {
        	int current = nums[i];
        	int next = nums[i + 1];
        	
        	if(current != next) {
        		expected += 1;
        		if(next != expected) {
        			disappearedNumber.add(expected);
        		}
        	}
        }
		
		return disappearedNumber;
    }

}
