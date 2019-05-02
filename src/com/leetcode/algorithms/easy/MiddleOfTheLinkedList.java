package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MiddleOfTheLinkedList {
	
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
		
		System.out.println(middleNode(node).val);
		
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
	
	public static ListNode middleNode(ListNode head) {
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
