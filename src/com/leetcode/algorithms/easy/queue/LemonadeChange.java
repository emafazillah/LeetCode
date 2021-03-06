package com.leetcode.algorithms.easy.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class LemonadeChange {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);		
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] bills = InputUtil.integerArr(inputs);
		
		// Output
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
					} else if(item == 5 && fives.isEmpty()) {
						return false;
					} else if(item == 10 && fives.isEmpty() && tens.isEmpty()) {
						return false;
					} else if(item == 15 && fives.isEmpty() && tens.isEmpty()) {
						return false;
					}
					
					int value = 0;
					
					if(!twenties.isEmpty() && item >= twenties.get(0)) {
						value += twenties.get(0);
						twenties.remove(0);
					}
					
					if(!tens.isEmpty() && item >= tens.get(0)) {
						value += tens.get(0);
						tens.remove(0);
					}
					
					if(!fives.isEmpty() && item >= fives.get(0)) {
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
