package com.leetcode.algorithms.medium.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class KthSmallest {
	
	static int kthSmallest(TreeNode root, int k) {
		List<Integer> list = treeNodeToSortedList(root, new ArrayList<>());
		return list.get(k - 1);
    }
	
	static List<Integer> treeNodeToSortedList(TreeNode root, List<Integer> arr) {
		if (root == null) {
			return arr;
		}
		
		treeNodeToSortedList(root.left, arr);
		arr.add(root.val);
		treeNodeToSortedList(root.right, arr);
		
		return arr;
	}
	
	static TreeNode insertTreeNode(TreeNode treeNode, int val) {
		if(treeNode == null) {
			return new TreeNode(val);
		}
		
		if(treeNode.val > val) {
			treeNode.left = insertTreeNode(treeNode.left, val);
		} else if(treeNode.val < val) {
			treeNode.right = insertTreeNode(treeNode.right, val);
		}
		
		return treeNode;
	}
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int k = scanner.nextInt();
		TreeNode root = null;
		for (int i = 0; i < inputs.length; i++) {
			if (!"null".equals(inputs[i])) {
				root = insertTreeNode(root, Integer.parseInt(inputs[i]));
			}
		}
		
		// Output
		System.out.println(kthSmallest(root, k));
		
		scanner.close();
	}

}
