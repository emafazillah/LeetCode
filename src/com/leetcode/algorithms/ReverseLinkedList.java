package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseLinkedList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<String> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String s = scanner.next();
			if(s.equals("exit")) {
				break;
			}
			inputs.add(s);
		}
		
		// Transform input list into node
		ListNode node = new ListNode(Integer.parseInt(inputs.get(inputs.size() - 1)));
		int count = inputs.size() - 2;
		while(count > -1) {
			ListNode temp = node;
			node = new ListNode(Integer.parseInt(inputs.get(count)));
			node.next = temp;
			--count;
		}
		
		// Print output
		ListNode output = reverseList(node);
		while(output.next != null) {
			System.out.println(output.val);
			output = output.next;
		}
		System.out.println(output.val);
		
		scanner.close();
	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	public static class ListNode {
		int val;
	    ListNode next;
	    
	    ListNode(int x) { 
	    	val = x; 
	    }
	}
	
	public static ListNode reverseList(ListNode head) {
		if(head == null) {
			return null;
		}
		
        // Reverse linked list
        // reverseListNode to store reverse list node
        ListNode reverseListNode = new ListNode(head.val);
    	while(head.next != null) {
    		ListNode temp = reverseListNode;
    		reverseListNode = new ListNode(head.next.val);
    		reverseListNode.next = temp;
			head = head.next;
    	}
		
		return reverseListNode;
    }

}
