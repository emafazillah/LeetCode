package com.leetcode.algorithms.easy.twopointers;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class TwoSumII {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] numbers = InputUtil.integerArr(inputs);
		int target = scanner.nextInt();
		
		// Output[index1, index2], index1 < index2
		int[] output = twoSum(numbers, target);
		
		// Print output
		System.out.println(Arrays.toString(output));
		
		scanner.close();
	}
	
	private static int[] twoSum(int[] numbers, int target) {
		int length = numbers.length;
		int[] result = new int[2];
		boolean isBreak = false;
		
		int i = 0;
		while(i < length) {
			int index1 = numbers[i];
			int j = 0;
			while(j < length) {
				if(j != i) {
					int index2 = numbers[j];
					if(index1 + index2 == target) {
						result[0] = i + 1;
						result[1] = j + 1;
						isBreak = true;
						
						break;
					}
				}
				
				++j;
			}
			
			if(isBreak) {
				break;
			}
			
			++i;
		}
		
		return result;
    }

}
