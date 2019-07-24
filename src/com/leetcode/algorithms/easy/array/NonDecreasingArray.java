package com.leetcode.algorithms.easy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonDecreasingArray {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			
			inputs.add(Integer.parseInt(input));
		}
		
		// Collection to Array
		int[] num = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			num[i] = inputs.get(i);
		}
		
		// Check possibility
		if(checkPossibility(num)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		scanner.close();
	}
	
	public static boolean checkPossibility(int[] num) {
		if(num.length == 0) {
			return false;
		} else {
			if(num.length == 1) {
				return true;
			} else {
				for(int i = 0; i < num.length; i++) {
					int test = num[i];
					for(int j = 0; j < num.length; j++) {
						if(test == num[j]) {
							break;
						} else {
							if(test < num[j]) {
								return false;
							}
						}
					}
				}
				
				return true;
			}
		}
	}

}
