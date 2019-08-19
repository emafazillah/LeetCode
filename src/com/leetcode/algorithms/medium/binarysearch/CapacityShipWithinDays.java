package com.leetcode.algorithms.medium.binarysearch;

import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class CapacityShipWithinDays {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int D = scanner.nextInt();
//		List<Integer> inputs = new ArrayList<>();
//		while(scanner.hasNext()) {
//			String input = scanner.next();
//			if("exit".equals(input)) {
//				break;
//			}
//			
//			inputs.add(Integer.parseInt(input));
//		}
		
		// Output
//		int[] weights = new int[inputs.size()];
//		for(int i = 0; i < inputs.size(); i++) {
//			weights[i] = inputs.get(i);
//		}
		
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] weights = InputUtil.integerArr(inputs);
		
		System.out.println(shipWithinDays(weights, D));
		
		scanner.close();
	}
	
	public static int shipWithinDays(int[] weights, int D) {
        
		
		
		return 0;
    }

}
