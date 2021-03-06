package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.leetcode.util.InputUtil;

public class PeakIndexInAMountainArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] A = InputUtil.integerArr(inputs);
		
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
