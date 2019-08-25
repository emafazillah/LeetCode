package com.leetcode.algorithms.easy.linkedlist;

import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.ListNode;

public class IntersectionOfTwoLinkedLists {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int intersectionVal = scanner.nextInt();
		ListNode headA = stringToListNode(scanner.next());		
		ListNode headB = stringToListNode(scanner.next());
		int skipA = scanner.nextInt();
		int skipB = scanner.nextInt();
		
		// Print output
		ListNode interSectinNode = getIntersectionNode(intersectionVal, headA, headB, skipA, skipB);
		if (interSectinNode == null) {
			System.out.println("null");
		} else {
			while (interSectinNode != null) {
				System.out.print(interSectinNode.val + "->");
				interSectinNode = interSectinNode.next;
			}
			System.out.print("null");
		}
		
		scanner.close();
	}
	
	static ListNode getIntersectionNode(int intersectionVal, ListNode headA, ListNode headB, int skipA, int skipB) {
        StringBuilder headAStrBldr = listNodeToStringBuilder(headA);
        StringBuilder headBStrBldr = listNodeToStringBuilder(headB);
		
		ListNode intersection = null;
		for (int i = 0; i < headAStrBldr.toString().length(); i++) {
			for (int j = 1; j < headAStrBldr.toString().length(); j++) {
				// Left substring
				String leftSubstring = headAStrBldr.toString().substring(i, headAStrBldr.toString().length() - j);
				if (headBStrBldr.toString().contains(leftSubstring)) {
					// Insert into ListNode, intersection
					char[] chars = leftSubstring.toCharArray();
					for(char c : chars) {
						intersection = insertListNode(intersection, Integer.parseInt(Character.toString(c)));
					}
					return intersection;
				}
				
				// Right substring
				String rightSubstring = headAStrBldr.toString().substring(j - i, headAStrBldr.toString().length());
				if (headBStrBldr.toString().contains(rightSubstring)) {
					// Insert into ListNode, intersection
					char[] chars = rightSubstring.toCharArray();
					for(char c : chars) {
						intersection = insertListNode(intersection, Integer.parseInt(Character.toString(c)));
					}
					return intersection;
				}					
			}
		}
		
		return intersection;
    }
	
	static StringBuilder listNodeToStringBuilder(ListNode head) {
		StringBuilder sb = new StringBuilder();
        while (head != null) {
        	sb.append(head.val);
        	head = head.next;
        }
        return sb;
	}
	
	static ListNode stringToListNode(String input) {
		String[] list = InputUtil.inputArr(input);
		// Input into ListNode
		ListNode head = null;
		for (String s : list) {
			head = insertListNode(head, Integer.parseInt(s));
		}
		return head;
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
