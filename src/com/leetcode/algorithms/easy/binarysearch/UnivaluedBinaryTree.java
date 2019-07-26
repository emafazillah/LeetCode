package com.leetcode.algorithms.easy.binarysearch;

import java.util.Scanner;

public class UnivaluedBinaryTree {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		TreeNode root = null;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String input = scanner.next();
			
			if("exit".equals(input)) {
				break;
			}
			
			if("null".equals(input)) {
				root = insertTreeNode(root, null);
			} else {
				root = insertTreeNode(root, Integer.parseInt(input));
			}
		}
		
		// Check if TreeNode is unival tree
		System.out.println(isUnivalTree(root));
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode treeNode, Integer input) {
		if(treeNode == null) {
			treeNode = new TreeNode(input);
			return treeNode;
		}
		
		if(input > treeNode.val) {
			treeNode.right = insertTreeNode(treeNode.right, input);
		} else if(input < treeNode.val) {
			treeNode.left = insertTreeNode(treeNode.left, input);
		} else {
			if(treeNode.right != null) {
				treeNode.right = insertTreeNode(treeNode.right, input);
			} else {
				treeNode.left = insertTreeNode(treeNode.left, input);
			}
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
