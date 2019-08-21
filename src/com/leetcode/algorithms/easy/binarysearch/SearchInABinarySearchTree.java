package com.leetcode.algorithms.easy.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class SearchInABinarySearchTree {
	
	private static List<Integer> outputTreeNodeList; // Optional
	
	public static void main(String...strings) {
		outputTreeNodeList = new ArrayList<>(); // Optional
		
		// Input
		Scanner scanner = new Scanner(System.in);
		String inputTree = scanner.next();
		int inputSearch = scanner.nextInt();
		
		// Insert into tree
		TreeNode inputTreeNode = null;
		String[] inputTreeArray = InputUtil.inputArr(inputTree);
		for(String input : inputTreeArray) {
			if(!"null".equals(input)) {
				inputTreeNode = insertTreeNode(inputTreeNode, Integer.parseInt(input));
			}
		}
		
		// Print output
		searchBST(inputTreeNode, inputSearch);
		Integer[] outputTreeNodeArray = new Integer[outputTreeNodeList.size()]; // Optional
		System.out.println(Arrays.toString(outputTreeNodeList.toArray(outputTreeNodeArray))); // Optional
		
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
        	return searchBST(root.right, val);
        }
        
        // Search left
        else if(val < root.val) {
        	return searchBST(root.left, val);
        }
        
        // Insert into array (Optional)
        else {
        	outputTreeNodeList.add(root.val);
        	
        	if(root.left != null) {
        		outputTreeNodeList.add(root.left.val);
        	}
        	
        	if(root.right != null) {
        		outputTreeNodeList.add(root.right.val);
        	}
        	
        	return root;
        }
    }
	
}
