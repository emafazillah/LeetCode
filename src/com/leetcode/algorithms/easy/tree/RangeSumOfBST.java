package com.leetcode.algorithms.easy.tree;

import java.util.Scanner;

import com.leetcode.util.TreeNode;

public class RangeSumOfBST {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int L = scanner.nextInt();
		int R = scanner.nextInt();
		TreeNode root = null;
		while(scanner.hasNext()) {
			String input = scanner.next();
			
			if("exit".equals(input)) {
				break;
			}
			
			if(!"null".equals(input)) {
				root = insertTreeNode(root, Integer.parseInt(input));
			}
		}
		
		// Print output
		System.out.println(rangeSumBST(root, L, R));
		
		scanner.close();
	}
	
	static TreeNode insertTreeNode(TreeNode root, int val) {
		if(root == null) {
			root = new TreeNode(val);
			return root;
		}
		
		if(val > root.val) {
			root.right = insertTreeNode(root.right, val);
		} else {
			root.left = insertTreeNode(root.left, val);
		}
		
		return root;
	}
	
	static int rangeSumBST(TreeNode root, int L, int R) {
		if(root == null) {
			return 0;
		}
		
		if(root.val < L) {
			return rangeSumBST(root.right, L, R);
		} else if(root.val > R) {
			return rangeSumBST(root.left, L, R);
		}
		
		return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }
	
}
