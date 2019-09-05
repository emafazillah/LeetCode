package com.leetcode.algorithms.medium.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.ListNode;

public class RemoveZeroSumSublists {

	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		ListNode listNode = null;
		for (int i = 0; i < inputs.length; i++) {
			listNode = insertListNode(listNode, Integer.parseInt(inputs[i]));
		}
		
		// Remove zero sum sublists
		listNode = removeZeroSumSublists(listNode);
		
		// Print output
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
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
	
	static ListNode removeZeroSumSublists(ListNode head) {
        ListNode listNode = head;
		int sum = 0;
		List<Integer> list = new ArrayList<>();
		while (listNode != null) {
			list.add(listNode.val);
			sum += listNode.val;
			if (sum == 0 && !list.isEmpty()) {
				// Update head
				for (int i = 0; i < list.size(); i++) {
					// TODO
				}
				
				// reset sum
				sum = 0;
				
				// reset list
				list.clear();
			}
			
			listNode = listNode.next;
		}
		
		return head;
    }
	
}
