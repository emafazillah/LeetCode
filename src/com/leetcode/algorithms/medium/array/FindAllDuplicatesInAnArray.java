package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class FindAllDuplicatesInAnArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
//		List<String> inputs = new ArrayList<>();
//		while(scanner.hasNext()) {
//			String s = scanner.next();
//			if(s.equals("exit")) {
//				break;
//			}
//			inputs.add(s);
//		}
		
		// Transform collection into array
//		int size = inputs.size();
//		int[] nums = new int[size];
//		for(int i = 0; i < size; i++) {
//			nums[i] = Integer.parseInt(inputs.get(i));
//		}
		
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		List<Integer> collResult = findDuplicates(nums);
		
		// Print result
		int[] arrResult = new int[collResult.size()];
		for(int i = 0; i < collResult.size(); i++) {
			arrResult[i] = collResult.get(i);
		}
		
		System.out.println(Arrays.toString(arrResult));
		
		scanner.close();
	}
	
	private static List<Integer> findDuplicates(int[] nums) {
		// Store duplicate key in map into list
        List<Integer> result = new ArrayList<>();
		
		// Count every number and store it into map
		Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	if (i == 0) {
        		map.put(nums[i], 1);
        	} else {
        		if(map.containsKey(nums[i]) && !result.contains(nums[i])) {
        			result.add(nums[i]);
        		} else {
        			map.put(nums[i], 1);
        		}
        	}
        }
        
		return result;
    }

}
