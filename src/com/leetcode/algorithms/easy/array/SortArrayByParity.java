package com.leetcode.algorithms.easy.array;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SortArrayByParity {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] A = InputUtil.integerArr(inputs);
		
		int[] result = sortArrayByParity(A);
		
		System.out.println(Arrays.toString(result));
		
		scanner.close();
	}
	
	public static int[] sortArrayByParity(int[] A) {
		int size = A.length;
		
        int[] result = new int[size];
		
        int count = 0;
        
        // Even
        for(int i = 0; i < size; i++) {
        	if(A[i] % 2 == 0) {
        		result[count] = A[i];
        		++count;
        	}
        }
        
        // Odd
        for(int i = 0; i < size; i++) {
        	if(A[i] % 2 != 0) {
        		result[count] = A[i];
        		++count;
        	}
        }
		
		return result;
    }

}
