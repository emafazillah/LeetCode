package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MajorityElement {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("q".equals(input)) {
				break;
			}
			inputs.add(input);
		}
		
		// Collection to Array
		int[] nums = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			nums[i] = Integer.parseInt(inputs.get(i));
		}
		
		// Print output
		System.out.println(majorityElement(nums));
		
		scanner.close();
	}
	
	public static int majorityElement(int[] nums) {
        // Count every element and store it in a Map
		Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	int key = nums[i];
        	if(map.containsKey(key)) {
        		int count = map.get(key);
        		map.put(key, ++count);
        	} else {
        		map.put(key, 1);
        	}
        }
        
        // Sort Map by value
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if((o2.getValue()).compareTo(o1.getValue()) == 0) {
					return (o2.getKey()).compareTo(o1.getKey());
				} else {
					return (o2.getValue()).compareTo(o1.getValue());
				}
			}
			
		});
		
		return list.get(0).getKey();
    }

}
