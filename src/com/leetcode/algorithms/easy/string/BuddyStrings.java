package com.leetcode.algorithms.easy.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class BuddyStrings {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String A = scanner.next();
		String B = scanner.next();
		
		// Print output
		System.out.print(buddyStrings(A, B));
		
		scanner.close();
	}
	
	static TreeMap<Character, Integer> insertTreeMap(char[] chars) {
		TreeMap<Character, Integer> map = new TreeMap<>();
		
		for (char c : chars) {
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, ++count);
			} else {
				map.put(c, 1);
			}
		}
		
		return map;
	}
	
	static boolean buddyStrings(String A, String B) {
		char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
		
		if (charA.length != charB.length) {
			return false;	
		} else if (A.equals(B)){
			List<Character> list = new ArrayList<>();
			
			for (int i = 0; i < charA.length; i++) {
				if (!list.contains(charA[i])) {
					list.add(charA[i]);
				}
			}
			
			if (list.size() == 1) {
				return true;
			} else {
				return false;
			}
		} else {
			TreeMap<Character, Integer> mapA = insertTreeMap(charA);
			TreeMap<Character, Integer> mapB = insertTreeMap(charB);
			
			if (!mapA.equals(mapB)) {
				return false;
			}
		}
		
		return true;
    }

}
