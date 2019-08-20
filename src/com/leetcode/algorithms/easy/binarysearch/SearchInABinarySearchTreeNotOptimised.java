package com.leetcode.algorithms.easy.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class SearchInABinarySearchTreeNotOptimised {
	
	private static List<Integer> outputTreeNodeList;
	
	public static void main(String...strings) {
		outputTreeNodeList = new ArrayList<>();
		
		// Input
		Scanner scanner = new Scanner(System.in);
		String inputTree = scanner.next();
//		inputTree = inputTree.replace("[", "");
//		inputTree = inputTree.replace("]", "");
		int inputSearch = scanner.nextInt();
		
		// Insert into tree
		TreeNodeSearchNotOptimised inputTreeNode = null;
//		String[] inputTreeArray = inputTree.split(",");
		String[] inputTreeArray = InputUtil.inputArr(inputTree);
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
	
	static TreeNodeSearchNotOptimised insertTreeNode(TreeNodeSearchNotOptimised treeNode, int input) {
		if(treeNode == null) {
			treeNode = new TreeNodeSearchNotOptimised(input);
			return treeNode;
		}
		
		if(input > treeNode.val) {
			treeNode.right = insertTreeNode(treeNode.right, input);
		} else if(input < treeNode.val) {
			treeNode.left = insertTreeNode(treeNode.left, input);
		}
		
		return treeNode;
	}
	
	static TreeNodeSearchNotOptimised searchBST(TreeNodeSearchNotOptimised root, int val) {
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

class TreeNodeSearchNotOptimised {
	int val;
    TreeNodeSearchNotOptimised left;
    TreeNodeSearchNotOptimised right;
    TreeNodeSearchNotOptimised(int x) { val = x; }
}
