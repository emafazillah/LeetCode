package com.leetcode.algorithms.medium.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SingleElementInASortedArray {
	
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
		int result = singleNonDuplicate(nums);
		
		System.out.println(result);
		
		scanner.close();
	}
	
	private static int singleNonDuplicate(int[] nums) {
		// Store number of array and number's count
		Map<Integer, Integer> map = new HashMap<>();
		map.put(nums[0], 1);
        int count = 1;
		for(int i = 1; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		map.remove(nums[i]);
        		++count;
        	} else {
        		count = 1;
        	}
        	
        	map.put(nums[i], count);
        }
		
		// Get single element
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		
		return 0;
    }

}
