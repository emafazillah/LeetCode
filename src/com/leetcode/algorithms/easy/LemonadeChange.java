package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.List;
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
		List<Integer> fives = new ArrayList<>();
		List<Integer> tens = new ArrayList<>();
		List<Integer> twenties = new ArrayList<>();
		
		for(int i = 0; i < bills.length; i++) {
			if(bills[i] > 5) {
				int item = bills[i] - 5;
				
				while(item >= 5) {
					if(fives.isEmpty() && tens.isEmpty() && twenties.isEmpty()) {
						return false;
					}
					
					int value = 0;
					
					if(!twenties.isEmpty()) {
						value += twenties.get(0);
						twenties.remove(0);
					}
					
					if(!tens.isEmpty()) {
						value += tens.get(0);
						tens.remove(0);
					}
					
					if(!fives.isEmpty()) {
						value += fives.get(0);
						fives.remove(0);
					}
					
					item -= value;
				}
			}
			
			switch(bills[i]) {
				case 5:
					fives.add(bills[i]);
					break;
				case 10:
					tens.add(bills[i]);
					break;
				case 20:
					twenties.add(bills[i]);
					break;
			}
		}
		
		return true;
    }

}
