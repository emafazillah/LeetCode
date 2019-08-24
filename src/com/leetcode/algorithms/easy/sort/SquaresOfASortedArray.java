package com.leetcode.algorithms.easy.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SquaresOfASortedArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);		
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] A = InputUtil.integerArr(inputs);
		
		// Output
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
