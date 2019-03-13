package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class PeakIndexInAMountainArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			int input = scanner.nextInt();
			if(input == -1) {
				break;
			}
			
			inputs.add(input);
		}
		
		// Collection to array
		int[] A = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			A[i] = inputs.get(i);
		}
		
		// Output
		System.out.println(peakIndexInMountainArray(A));
		
		scanner.close();
	}
	
	public static int peakIndexInMountainArray(int[] A) {
        // Put into Map
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < A.length; i++) {
			map.put(i, A[i]);
		}
		
		// Sort Map by value in descending order
		Set<Entry<Integer, Integer>> set = map.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
			
		});
		
		return list.get(0).getKey();
    }

}
