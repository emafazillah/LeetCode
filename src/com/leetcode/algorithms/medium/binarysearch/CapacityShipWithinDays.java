package com.leetcode.algorithms.medium.binarysearch;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class CapacityShipWithinDays {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int D = scanner.nextInt();
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] weights = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(shipWithinDays(weights, D));
		
		scanner.close();
	}
	
	public static int shipWithinDays(int[] weights, int D) {
        
		
		
		return 0;
    }

}
