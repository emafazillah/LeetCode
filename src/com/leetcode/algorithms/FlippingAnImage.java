package com.leetcode.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class FlippingAnImage {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int columns = scanner.nextInt();
		int rows = scanner.nextInt();
		int[][] A = new int[rows][columns];
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				A[x][y] = scanner.nextInt();
			}
		}
		
		flipAndInvertImage(A);
		
		scanner.close();
	}
	
	public static int[][] flipAndInvertImage(int[][] A) {
		for(int[] B : A) {
			int max = B.length - 1;
			int min = 0;
			
			while(max >= min) {
        		// Reverse
				if(max > min) {
					int temp = B[max];
					B[max] = B[min];
					B[min] = temp;
				}
        		
        		// Invert
        		if(B[max] == 1) {
        			B[max] = 0;
        		} else if(B[max] == 0) {
        			B[max] = 1;
        		}
        		
        		if(max > min) {
	        		if(B[min] == 1) {
	        			B[min] = 0;
	        		} else if(B[min] == 0) {
	        			B[min] = 1;
	        		}
        		}
        		
        		// Update min & max
        		--max;
        		++min;
        	}
			
			//System.out.println(Arrays.toString(B));
        }
		
        return A;
    }

}
