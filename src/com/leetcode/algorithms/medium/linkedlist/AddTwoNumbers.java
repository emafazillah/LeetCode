package com.leetcode.algorithms.medium.linkedlist;

import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.ListNode;

public class AddTwoNumbers {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		
		String[] inputs1 = InputUtil.inputArr(scanner.next());
		ListNode listNode1 = null;
		for (String input1 : inputs1) {
			listNode1 = insertListNode(listNode1, Integer.parseInt(input1));
		}
		
		String[] inputs2 = InputUtil.inputArr(scanner.next());
		ListNode listNode2 = null;
		for (String input2 : inputs2) {
			listNode2 = insertListNode(listNode2, Integer.parseInt(input2));
		}
		
		// Add two linked list
		ListNode result = addTwoNumbers(listNode1, listNode2);
		
		// Print output
		while (result != null) {
			System.out.print(result.val);
			result = result.next;
		}
		
		scanner.close();
	}
	
	static ListNode insertListNode(ListNode listNode, int val) {
		if (listNode == null) {
			listNode = new ListNode(val);
		} else {
			listNode.next = insertListNode(listNode.next, val);
		}
		
		return listNode;
	}
	
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		int sum = 0;
		while (l1 != null || l2 != null) {
			int x = 0;
			if (l1 != null) {
				x = l1.val;
			}
			
			int y = 0;
			if (l2 != null) {
				y = l2.val;
			}
			
			sum += x + y;
			
			if (sum >= 10) {
				result = insertListNode(result, sum - 10);
				sum = 1;
			} else {
				result = insertListNode(result, sum);
				sum = 0;
			}
			
			if (l1 != null) {
				l1 = l1.next;
			}
			
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		
		if (sum > 0) {
			result = insertListNode(result, sum);
		}
		
		return result;
    }

}
