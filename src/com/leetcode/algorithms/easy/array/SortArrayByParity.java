package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SortArrayByParity {
	
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
		
		// Transform collection into array
		int[] A = new int[count];
		for(int i = 0; i < inputs.size(); i++) {
			A[i] = inputs.get(i);
		}
		
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
