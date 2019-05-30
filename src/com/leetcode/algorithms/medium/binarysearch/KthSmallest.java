package com.leetcode.algorithms.medium.binarysearch;

import java.util.Scanner;

public class KthSmallest {
	
	static int count = 0;
	
	public static int kthSmallest(TreeNode root, int k) {
        if(root == null) {
        	return 0;
        }
        
        if(root.left != null) {
        	++count;
            
            if(count == k) {
            	return count;
            } else {
            	return kthSmallest(root.left, k);
            }
        } else {
        	return kthSmallest(root.right, k);
        }
    }
	
	public static TreeNode insertTreeNode(TreeNode treeNode, int val) {
		if(treeNode == null) {
			return new TreeNode(val);
		}
		
		if(treeNode.val > val) {
			treeNode.right = insertTreeNode(treeNode.right, val);
		} else if(treeNode.val < val) {
			treeNode.left = insertTreeNode(treeNode.left, val);
		}
		
		return treeNode;
	}
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		TreeNode root = null;
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			
			if(!"null".equals(input)) {
				int value = Integer.parseInt(input);
				root = insertTreeNode(root, value);
			}
		}
		
		// Output
		System.out.println(kthSmallest(root, k));
		
		scanner.close();
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
