package com.leetcode.algorithms.easy;

import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(isValid(scanner.next()));
		
		scanner.close();
	}
	
	public static boolean isValid(String s) {
		// Check if s length is even
        if(s.length() % 2 != 0) {
        	return false;
        }
		
        Stack<Character> stack = new Stack<>();
		for (Character bracket : s.toCharArray()) {
			switch (bracket) {
				case '{':
					stack.push('}');
					break;
				case '(':
					stack.push(')');
					break;
				case '[':
					stack.push(']');
					break;
				default:
					if(stack.empty() || bracket != stack.peek()) { // Check if stack is empty or top of stack is close bracket
						return false;
					}
				stack.pop();
			}
		}
		
		return stack.isEmpty();
    }

}
