package com.leetcode.algorithms.easy.linkedlist;

import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.ListNode;

public class ReverseLinkedList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		ListNode listNode = null;
		for (int i = 0; i < inputs.length; i++) {
			listNode = insertNodeList(listNode, Integer.parseInt(inputs[i]));
		}		
				
		// Print output
		ListNode output = reverseList(listNode);
		while(output.next != null) {
			System.out.println(output.val);
			output = output.next;
		}
		System.out.println(output.val);
		
		scanner.close();
	}
	
	static ListNode insertNodeList(ListNode listNode, int val) {
		if (listNode == null) {
			listNode = new ListNode(val);
		} else {
			listNode.next = insertNodeList(listNode.next, val);
		}
		
		return listNode;
	}
	
	static ListNode reverseList(ListNode head) {
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
