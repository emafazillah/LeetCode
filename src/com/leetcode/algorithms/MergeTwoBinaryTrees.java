package com.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeTwoBinaryTrees {
	
	private static List<Integer> mergedTreeNodes;
	
	public static void main(String...strings) {
		mergedTreeNodes = new ArrayList<>();
		
		// Input
		Scanner scanner = new Scanner(System.in);
		
		String input1 = scanner.next();
		input1 = input1.replace("[", "");
		input1 = input1.replace("]", "");
		
		String input2 = scanner.next();
		input2 = input2.replace("[", "");
		input2 = input2.replace("]", "");
		
		// TreeNode, t1
		String[] arrInput1 = input1.split(",");
		
		TreeNodeMerged t1 = null;
		for(String input : arrInput1) {
			if(!"null".equals(input)) {
				t1 = insertTreeNode(t1, Integer.parseInt(input));
			}
		}
		
		// TreeNode, t2
		String[] arrInput2 = input2.split(",");
		
		TreeNodeMerged t2 = null;
		for(String input : arrInput2) {
			if(!"null".equals(input)) {
				t2 = insertTreeNode(t2, Integer.parseInt(input));
			}
		}
		
		// MERGE TREES
		mergeTrees(t1, t2);
		
		// Print output
		Integer[] mergedTreeNodesArray = new Integer[mergedTreeNodes.size()];
		System.out.println(Arrays.toString(mergedTreeNodes.toArray(mergedTreeNodesArray)));
		
		
		scanner.close();
	}
	
	static TreeNodeMerged insertTreeNode(TreeNodeMerged treeNode, int input) {
		if(treeNode == null) {
			treeNode = new TreeNodeMerged(input);
			return treeNode;
		}
		
		if(input > treeNode.val) {
			treeNode.right = insertTreeNode(treeNode.right, input);
		} else {
			treeNode.left = insertTreeNode(treeNode.left, input);
		}
		
		return treeNode;
	}
	
	static TreeNodeMerged mergeTrees(TreeNodeMerged t1, TreeNodeMerged t2) {
		if(t1 == null && t2 == null) {
			return null;
		}
		
		// mergedTreeNode
		int val = 0;
		if(t1 != null && t2 != null) {
			val = t1.val + t2.val;
		} else if(t1 != null && t2 == null) {
			val = t1.val;
		} else if(t1 == null && t2 != null) {
			val = t2.val;
		}
		
		//System.out.println(val);
		mergedTreeNodes.add(val);
		
		TreeNodeMerged mergedTreeNode = new TreeNodeMerged(val);
        
        // mergedTreeNode left
		if(t1 != null && t2 != null) {
			mergedTreeNode.left = mergeTrees(t1.left, t2.left);
		} else if(t1 != null && t2 == null) {
			mergedTreeNode.left = mergeTrees(t1.left, null);
		} else if(t1 == null && t2 != null) {
			mergedTreeNode.left = mergeTrees(null, t2.left);
		}
		
		// mergedTreeNode right
		if(t1 != null && t2 != null) {
			mergedTreeNode.right = mergeTrees(t1.right, t2.right);
		} else if(t1 != null && t2 == null) {
			mergedTreeNode.right = mergeTrees(t1.right, null);
		} else if(t1 == null && t2 != null) {
			mergedTreeNode.right = mergeTrees(null, t2.right);
		}
		
		return mergedTreeNode;
    }
}

//Definition for a binary tree node.
class TreeNodeMerged {
	int val;
	TreeNodeMerged left;
	TreeNodeMerged right;
	TreeNodeMerged(int x) { val = x; }
}