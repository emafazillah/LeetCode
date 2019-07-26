package com.leetcode.algorithms.easy.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnivaluedBinaryTree {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		List<String> inputs = new ArrayList<>();
		TreeNode root = null;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			
			inputs.add(input);
		}
		
		for(int i = 0; i < inputs.size(); i++) {
			root = insertTreeNode(root, inputs.get(i));
		}
		
		// Check if TreeNode is unival tree
		System.out.println(isUnivalTree(root));
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode treeNode, String input) {
		if(treeNode == null) {
			if(!"null".equals(input)) {
				treeNode = new TreeNode(Integer.parseInt(input));
			}
			return treeNode;
		}
		
		if(treeNode.left == null && !"null".equals(input)) {
			treeNode.left = insertTreeNode(treeNode.left, input);
		} else if(treeNode.right == null && !"null".equals(input)) {
			treeNode.right = insertTreeNode(treeNode.right, input);
		}
		
		return treeNode;
	}
	
	public static boolean isUnivalTree(TreeNode root) {
		if(root == null) {
			return false;
		}
		
		int val = root.val;
		boolean result = true;
		
		while(root != null) {
			// Check left
			if(root.left != null) {
				if(val > root.left.val || val < root.right.val) {
					result = false;
					break;
				} else {
					root.left = root.left.left;
				}
			} 
			// Check right
			else {
				if(val > root.left.val || val < root.right.val) {
					result = false;
					break;
				} else {
					root.right = root.right.right;
				}
			}
		}
		
		return result;
    }

}
