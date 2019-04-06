package com.leetcode.algorithms;

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
			System.out.println("i==="+i);
			
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
        	
        	System.out.println("isCorrectOrder==="+isCorrectOrder);
        	
        	list[i] = isCorrectOrder;
        }
		
		int count = 0;
		
		for(int i = 0; i < list.length; i++) {
			boolean previous = true;
			boolean current = true;
			boolean next = true;
			
			if(i == 0 || i == list.length - 1) {
				current = list[i];
				
				if(current == false) {
					++count;
				}
			} else {
				previous = list[i - 1];
				current = list[i];
				next = list[i + 1];
				
				if(current == false) {
					++count;
				} else if(previous == false && current == true && next == false) {
					++count;
				}
			}
		}
		
		return count;
    }

}
