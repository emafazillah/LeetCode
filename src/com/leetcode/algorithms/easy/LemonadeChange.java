package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < bills.length; i++) {
			if(bills[i] > 5) {
				int item = bills[i] - 5;
				int value = 0;
				
				while(item >= 5) {
					if(queue.isEmpty()) {
						return false;
					}
					
					value += queue.peek();
					if(item % value == 0) {
						item -= value;
					}
					queue.remove();
				}
			}
			
			queue.add(bills[i]);
		}
		
		return true;
    }

}
