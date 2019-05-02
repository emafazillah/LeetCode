package com.leetcode.algorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchInABinarySearchTree {
	
	private static List<Integer> outputTreeNodeList;
	
	public static void main(String...strings) {
		outputTreeNodeList = new ArrayList<>();
		
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
		Integer[] outputTreeNodeArray = new Integer[outputTreeNodeList.size()];
		System.out.println(Arrays.toString(outputTreeNodeList.toArray(outputTreeNodeArray)));
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode treeNode, int input) {
		if(treeNode == null) {
			treeNode = new TreeNode(input);
			return treeNode;
		}
		
		if(input > treeNode.val) {
			treeNode.right = insertTreeNode(treeNode.right, input);
		} else if(input < treeNode.val) {
			treeNode.left = insertTreeNode(treeNode.left, input);
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
        
        // Insert into array
        else {
        	outputTreeNodeList.add(root.val);
        	
        	if(root.left != null) {
        		outputTreeNodeList.add(root.left.val);
        	}
        	
        	if(root.right != null) {
        		outputTreeNodeList.add(root.right.val);
        	}
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
