package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SquaresOfASortedArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		int count = 0;
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			} else {
				inputs.add(input);
				++count;
			}
		}
		
		// Transform collection into array
		int[] A = new int[count];
		for(int i = 0; i < inputs.size(); i++) {
			A[i] = Integer.parseInt(inputs.get(i));
		}
		
		int[] result = sortedSquares(A);
		
		System.out.println(Arrays.toString(result));
		
		scanner.close();
	}
	
	public static int[] sortedSquares(int[] A) {
		int[] result = new int[A.length];
		
		// Get square
		for(int i = 0; i < A.length; i++) {
			result[i] = A[i] * A[i];
		}
		
		// Sort list of square
		Arrays.sort(result);
		
		return result;
    }

}
