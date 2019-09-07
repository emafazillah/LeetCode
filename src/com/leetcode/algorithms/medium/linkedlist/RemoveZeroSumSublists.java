package com.leetcode.algorithms.medium.linkedlist;

import java.util.HashMap;
import java.util.Map;
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
			System.out.print(listNode.val + ",");
			listNode = listNode.next;
		}
		System.out.println();
		
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
		Map<Integer, ListNode> map = new HashMap<>();
        boolean isZeroSum = true; 
        
        while (isZeroSum) {
        	isZeroSum = false;
        	int sum = 0;
        	ListNode temp = head;
        	
        	while (temp != null) {
        		sum += temp.val;
        		
        		if (sum == 0) {
        			head = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		} else if (map.containsKey(sum)) {
        			map.get(sum).next = temp.next;
        			map.clear();
        			isZeroSum = true;
        			break;
        		}
        		
        		map.put(sum, temp);
        		temp = temp.next;
        	}
        }
        
        return head;
    }
	
}
