package com.leetcode.algorithms.easy.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class UnivaluedBinaryTree {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		Scanner scanner = new Scanner(System.in);
		String[] inputsArray = InputUtil.inputArr(scanner.next());
		
		TreeNode root = null;
		for(String input : inputsArray) {
			if(!"null".equals(input)) {
				root = insertTreeNode(root, input);
			}
		}
		
		// Check if TreeNode is unival tree
		System.out.println(isUnivalTree(root));
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode treeNode, String input) {
		if(treeNode == null) {
			treeNode = new TreeNode(Integer.parseInt(input));
		} else {
			if(treeNode.right == null) {
				treeNode.right = insertTreeNode(treeNode.right, input);
			} else {
				treeNode.left = insertTreeNode(treeNode.left, input);
			}
		}
		
		return treeNode;
	}
	
	static List<Integer> nodeList;
	
	public static boolean isUnivalTree(TreeNode root) {
		if(root == null) {
			return false;
		}
		
		boolean result = true;
		
		nodeList = new ArrayList<>();
		dfs(root);
		for(int i = 0; i < nodeList.size() - 1; i++) {
			if(nodeList.get(i) != nodeList.get(i + 1)) {
				result = false;
				break;
			}
		}
		
		return result;
    }
	
	public static void dfs(TreeNode node) {
		if(node != null) {
			nodeList.add(node.val);
			dfs(node.left);
			dfs(node.right);
		}
	}

}
