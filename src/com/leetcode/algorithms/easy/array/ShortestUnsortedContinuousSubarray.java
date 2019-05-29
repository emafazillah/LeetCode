package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestUnsortedContinuousSubarray {
	
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
		System.out.println(findUnsortedSubarray(nums));
		
		scanner.close();
	}
	
	public static int findUnsortedSubarray(int[] nums) {
		boolean[] list = new boolean[nums.length];
        
		for(int i = 0; i < nums.length; i++) {
			int numi = nums[i];
        	
        	boolean isCorrectOrder = true;
        	
        	for(int j = 0; j < nums.length; j++) {
        		int numj = nums[j];
        		
        		if(i != j) {
        			if((numi > numj && i < j) || (numi < numj && i > j)) {
        				isCorrectOrder = false;
        				break;
        			}
        		}
        	}
        	
        	list[i] = isCorrectOrder;
        }
		
		int count = 0;
		
		int x = 0;
		
		for(int i = 0; i < list.length; i++) {
			if(list[i]) {
				++x;
			} else {
				break;
			}
		}
		
		int y = list.length - 1;
		
		for(int i = list.length - 1; i >= 0; i--) {
			if(list[i]) {
				--y;
			} else {
				break;
			}
		}
		
		for(int i = x; i <= y; i++) {
			++count;
		}
		
		return count;
    }

}
