package com.leetcode.algorithms.easy.sort;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SortArrayByParityII {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);		
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] A = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(Arrays.toString(sortArrayByParityII(A)));
		
		scanner.close();
	}
	
	public static int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
		
        
        int[] even = new int[A.length / 2];
        int[] odd = new int[A.length / 2];
        int countEven = 0;
        int countOdd = 0;
        
        // Sort odd or even
        for(int i = 0; i < A.length; i++) {
        	int item = A[i];        	
        	if(item % 2 == 0) {
        		even[countEven] = item;
        		++countEven;
        	} else {
        		odd[countOdd] = item;
        		++countOdd;
        	}
        }
        
        // Sort by parity
        countEven = 0;
        countOdd = 0;
        for(int i = 0; i < result.length; i++) {
        	if(i % 2 == 0) {
    			result[i] = even[countEven];
    			++countEven;
    		} else {
    			result[i] = odd[countOdd];
    			++countOdd;
    		}
        }
		
        return result;
    }

}
