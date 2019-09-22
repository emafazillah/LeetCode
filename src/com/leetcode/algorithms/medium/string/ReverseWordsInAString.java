package com.leetcode.algorithms.medium.string;

public class ReverseWordsInAString {
	
	public static void main(String...strings) {
		String s = "the sky is blue";
		System.out.println(reverseWords(s));
	}
	
	static String reverseWords(String s) {
		if (s.isEmpty()) {
			return s;
		}
		
		String[] arr = s.split(" ");
		
		if (arr.length == 1) {
			return s.trim();
		}
		
		StringBuilder sb = new StringBuilder();
		int idx = arr.length - 1;
		while (idx > -1) {
			if (!arr[idx].isEmpty()) {
				sb.append(arr[idx]).append(" ");
			}
			--idx;
		}
		
        return sb.toString().trim();
    }

}
