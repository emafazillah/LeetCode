package com.leetcode.algorithms.easy.linkedlist;

import java.util.Scanner;

public class IntersectionOfTwoLinkedLists {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String inputA = scanner.next();
		inputA = inputA.replace("[", "");
		inputA = inputA.replace("]", "");
		String[] listA = inputA.split(",");
		
		String inputB = scanner.next();
		inputB = inputB.replace("[", "");
		inputB = inputB.replace("]", "");
		String[] listB = inputB.split(",");
		
		// Input into ListNode
		ListNode headA = null;
		for (String a : listA) {
			headA = insertListNode(headA, Integer.parseInt(a));
		}
		
		ListNode headB = null;
		for (String b : listB) {
			headB = insertListNode(headB, Integer.parseInt(b));
		}
		
		// Print output
		ListNode interSectinNode = getIntersectionNode(headA, headB);
		if (interSectinNode == null) {
			System.out.println("null");
		} else {
			while (interSectinNode != null) {
				System.out.print(interSectinNode.val + "->");
				interSectinNode = interSectinNode.next;
			}
		}
		
		scanner.close();
	}
	
	static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        StringBuffer headASb = new StringBuffer();
        while (headA != null) {
        	headASb.append(headA.val);
        	headA = headA.next;
        }
		
		StringBuffer headBSb = new StringBuffer();
		while (headB != null) {
			headBSb.append(headB.val);
			headB = headB.next;
		}
		
		ListNode intersection = null;
		for (int i = 0; i < headASb.toString().length() - 1; i++) {
			String subStrA = headASb.toString().substring(i, headASb.toString().length());
			// Check if substring of headASb contains in headBSb
			if (headBSb.toString().contains(subStrA)) {
				// Insert into ListNode, intersection
				char[] subStrAchar = subStrA.toCharArray();
				for(char c : subStrAchar) {
					intersection = insertListNode(intersection, Integer.parseInt(Character.toString(c)));
				}
				break;
			}
		}
		
		return intersection;
    }
	
	static ListNode insertListNode(ListNode listNode, int val) {
		if (listNode == null) {
			listNode = new ListNode(val);
		} else {
			listNode.next = insertListNode(listNode.next, val);
		}
		
		return listNode; 
	}

}

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
		next = null;
	}
}
