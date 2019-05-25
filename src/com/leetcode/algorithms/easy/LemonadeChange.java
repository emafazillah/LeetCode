package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class LemonadeChange {
	
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
		
		// Output
		int[] bills = new int[inputs.size()];
		for(int i = 0; i < inputs.size(); i++) {
			bills[i] = inputs.get(i);
		}
		
		System.out.println(lemonadeChange(bills));
		
		scanner.close();
	}
	
	static boolean lemonadeChange(int[] bills) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < bills.length; i++) {
			int item = bills[i];
			if(item == 5) {
				stack.push(item);
			} else {
				while(item > 5) {
					if(stack.isEmpty()) {
						return false;
					}
					stack.pop();
					stack.push(item);
					item -= 5;					
				}
			}
		}
		
		return true;
    }

}
