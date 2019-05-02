package com.leetcode.algorithms.easy;

import java.util.Scanner;

public class SearchInABinarySearchTree {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String inputTree = scanner.next();
		inputTree = inputTree.replace("[", "");
		inputTree = inputTree.replace("]", "");
		int inputSearch = scanner.nextInt();
		
		// Insert into tree
		TreeNode inputTreeNode = null;
		String[] inputTreeArray = inputTree.split(",");
		for(String input : inputTreeArray) {
			if(!"null".equals(input)) {
				inputTreeNode = insertTreeNode(inputTreeNode, Integer.parseInt(input));
			}
		}
		
		// Print output
		searchBST(inputTreeNode, inputSearch);
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode treeNode, int input) {
		if(treeNode == null) {
			treeNode = new TreeNode(input);
			return treeNode;
		}
		
		if(input > treeNode.val) {
			treeNode.right = insertTreeNode(treeNode, input);
		} else if(input < treeNode.val) {
			treeNode.left = insertTreeNode(treeNode, input);
		}
		
		return treeNode;
	}
	
	static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
        	return null;
        }
		
        // Search right
        if(val > root.val) {
        	root.right = searchBST(root.right, val);
        }
        
        // Search left
        else if(val < root.val) {
        	root.left = searchBST(root.left, val);
        }
		
		return root;
    }

}

class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
