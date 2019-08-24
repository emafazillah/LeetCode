package com.leetcode.algorithms.easy.linkedlist;

import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.ListNode;

public class MiddleOfTheLinkedList {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);		
		String[] inputs = InputUtil.inputArr(scanner.next());
		ListNode listNode = null;
		for (int i = 0; i < inputs.length; i++) {
			listNode = insertListNode(listNode, Integer.parseInt(inputs[i]));
		}
		
		// Output
		System.out.println(middleNode(listNode).val);
		
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
	
	static ListNode middleNode(ListNode head) {
		// If head is null
        if (head == null) {
        	return null;
        }
		
        // Get middle of the node
        ListNode temp = head;
        int count = 1;
		while(temp.next != null) {
			temp = temp.next;
			++count;
		}
		
		int middlePoint = count / 2;
		int countMiddlePoint = 0;
		while(countMiddlePoint < middlePoint) {
			head = head.next;
			++countMiddlePoint;
		}
		
		return head;
    }

}
