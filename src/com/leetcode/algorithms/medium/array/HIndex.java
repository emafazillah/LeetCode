package com.leetcode.algorithms.medium.array;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class HIndex {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] citations = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Output
		System.out.println(hIndex(citations));
		
		scanner.close();
	}
	
	static int hIndex(int[] citations) {
		if (citations.length == 0) {
			return 0;
		}
		
		Arrays.sort(citations);
		
		int count = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
        	if (citations[i] > count) {
        		++count;
        	}
        }
        
        return count;
    }

}
