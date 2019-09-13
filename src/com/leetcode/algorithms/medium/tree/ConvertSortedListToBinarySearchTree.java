package com.leetcode.algorithms.medium.tree;

import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;

public class ConvertSortedListToBinarySearchTree {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] list = InputUtil.inputArr(scanner.next());
		ListNode head = null;
		for (String s : list) {
			head = insertListNode(head, Integer.parseInt(s));
		}
		
		// Convert sorted list to Binary Search Tree
		TreeNode root = sortedListToBST(head);
		
		scanner.close();
	}
	
	static ListNode insertListNode(ListNode head, int val) {
		if (head == null) {
			return new ListNode(val);
		} else {
			head.next = insertListNode(head.next, val);
			return head;
		}
	}
	
	static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		
        // Get middle node
        ListNode middleNode = getMiddleNodeVal(head);
        
        TreeNode root = new TreeNode(middleNode.val);
        
        if (head == middleNode) {
        	return root;
        }
        
		// Build BST recursively
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middleNode.next);
		
		return root;
    }
	
	static ListNode getMiddleNodeVal(ListNode head) {
		ListNode prev = null;
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (prev != null) {
			prev.next = null;
		}
		
		return slow;
	}

}
