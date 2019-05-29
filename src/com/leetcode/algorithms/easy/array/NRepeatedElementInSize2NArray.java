package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class NRepeatedElementInSize2NArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		int count = 0;
		while(scanner.hasNext()) {
			int input = scanner.nextInt();
			if(input == 0) {
				break;
			} else {
				inputs.add(input);
				++count;
			}
		}
		
		// Collection to array
		int[] A = new int[count];
		for(int i = 0; i < count; i++) {
			A[i] = inputs.get(i);
		}
		
		// Print the result
		System.out.println(repeatedNTimes(A));
		
		scanner.close();
	}
	
	public static int repeatedNTimes(int[] A) {
		// Count key
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for(int i = 0; i < A.length; i++) {
        	if(map.get(A[i]) == null) {
        		count = 1;
        		map.put(A[i], count);
        	} else {
        		++count;
        		map.remove(A[i]);
        		map.put(A[i], count);
        	}
        }
        
        // Sort map
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o2.getValue().compareTo(o1.getValue()) == 0) {
					return o2.getKey().compareTo(o1.getKey());
				} else {
					return o2.getValue().compareTo(o1.getValue());
				}
			}
		});
		
		return list.get(0).getKey();
    }

}
