package com.leetcode.algorithms.easy.binarysearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class InvertBinarySearch {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		Scanner scanner = new Scanner(System.in);
		String[] inputArr = InputUtil.inputArr(scanner.next());
		TreeNode root = null;
		for(String input : inputArr) {
			root = insertTreeNode(root, Integer.parseInt(input));
		}
		
		// Invert tree
		root = invertTree(root);
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode root, int input) {
		if(root == null) {
			root = new TreeNode(input);
		} else {
			if(input > root.val) {
				root.right = insertTreeNode(root.right, input);
			} else {
				root.left = insertTreeNode(root.left, input);
			}
		}
		
		return root;
	}
	
	static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    
	    while(!queue.isEmpty()) {
	        TreeNode current = queue.poll();
	        TreeNode temp = current.left;
	        current.left = current.right;
	        current.right = temp;
	        if (current.left != null) queue.add(current.left);
	        if (current.right != null) queue.add(current.right);
	    }
	    
	    return root;
    }

}
