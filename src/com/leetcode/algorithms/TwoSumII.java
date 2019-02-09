package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSumII {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String s = scanner.next();
			if(s.equals("exit")) {
				break;
			}
			inputs.add(s);
		}
		
		// List to array
		// inputs[0] - inputs[array length - 2]
		// inputs[array length - 1] = target
		int[] numbers = new int[inputs.size() - 1];
		int i = 0;
		while(i < inputs.size() - 1) {
			numbers[i] = Integer.parseInt(inputs.get(i));
			++i;
		}
		
		// Output[index1, index2], index1 < index2
		int[] output = twoSum(numbers, Integer.parseInt(inputs.get(inputs.size() - 1)));
		
		System.out.println(output[0] + "," + output[1]);
		
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
