package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class ThreeSum {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Print output
		List<List<Integer>> result = threeSum(nums);
		for (List<Integer> list : result) {
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
		
		scanner.close();
	}
	
	static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int first = 0; first < nums.length; first++) {
        	int sum = nums[first];
        	int second = first + 1;
        	while (second < nums.length) {
            	int third = second + 1;
            	while (third < nums.length) {
            		sum += nums[second] + nums[third];
            		if (sum == 0) {
            			List<Integer> list = new ArrayList<>();
            			list.add(nums[first]);
            			list.add(nums[second]);
            			list.add(nums[third]);
            			map.put(list, 0);
            			break;
            		} else {
            			sum = nums[first];
            			++third;
            		}
            	}
            	sum = nums[first];
            	++second;
        	}
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
        	result.add(entry.getKey());
        }
        return result;
    }

}
