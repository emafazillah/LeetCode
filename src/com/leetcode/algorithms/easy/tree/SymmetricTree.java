package com.leetcode.algorithms.easy.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class SymmetricTree {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] arr = InputUtil.inputArr(scanner.next());
		TreeNode root = insertTreeNode(arr);
		
		// Output
		System.out.println(isSymmetric(root));
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(String[] arr) {
		TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
		TreeNode node1 = null;
		TreeNode node2 = null;
		TreeNode node3 = null;
		TreeNode node4 = null;
		TreeNode node5 = null;
		TreeNode node6 = null;
		
		if (!"null".equals(arr[1])) {
			node1 = new TreeNode(Integer.parseInt(arr[1]));
		}
		
		if (!"null".equals(arr[2])) {
			node2 = new TreeNode(Integer.parseInt(arr[2]));
		}
		
		if (!"null".equals(arr[3])) {
			node3 = new TreeNode(Integer.parseInt(arr[3]));
		}
		
		if (!"null".equals(arr[4])) {
			node4 = new TreeNode(Integer.parseInt(arr[4]));
		}
		
		if (!"null".equals(arr[5])) {
			node5 = new TreeNode(Integer.parseInt(arr[5]));
		}
		
		if (!"null".equals(arr[6])) {
			node6 = new TreeNode(Integer.parseInt(arr[6]));
		}
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		return root;
	}
	
	static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
	    q.add(root);
	    q.add(root);
	    
	    while (!q.isEmpty()) {
	        TreeNode t1 = q.poll();
	        TreeNode t2 = q.poll();
	        
	        if (t1 == null && t2 == null) {
	        	continue;
	        }
	        
	        if (t1 == null || t2 == null) {
	        	return false;
	        }
	        
	        if (t1.val != t2.val) {
	        	return false;
	        }
	        
	        q.add(t1.left);
	        q.add(t2.right);
	        q.add(t1.right);
	        q.add(t2.left);
	    }
	    
	    return true;
    }

}
