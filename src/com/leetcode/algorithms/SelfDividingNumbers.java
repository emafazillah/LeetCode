package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SelfDividingNumbers {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int left = scanner.nextInt();
		int right = scanner.nextInt();
		
		List<Integer> result = selfDividingNumbers(left, right);
		Integer[] arr = result.toArray(new Integer[result.size()]);
		System.out.println(Arrays.toString(arr));
		
		scanner.close();
	}
	
	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<>();
		
        while(left <= right) {
        	String stringI = Integer.toString(left);
        	char[] charI = stringI.toCharArray();
        	boolean isSelfDividing = false;
        	for(char c : charI) {
        		int num = Character.getNumericValue(c);
        		
        		if(num == 0) {
        			isSelfDividing = false;
        			break;
        		}
        		
        		if(left % num == 0) {
        			isSelfDividing = true;
        		} else {
        			isSelfDividing = false;
        			break;
        		}
        	}
        	
        	if(isSelfDividing) {
        		result.add(left);
        	}
        	
        	++left;
        }
		
		return result;
    }

}
