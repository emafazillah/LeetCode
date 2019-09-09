package com.leetcode.algorithms.medium.tree;

import com.leetcode.util.TreeNode;

public class ValidateBinarySearchTree {
	
	TreeNode previousNode;
	
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
        	return true;
        }
		
		if (!isValidBST(root.left)) {
			return false;
		}
		
		if (previousNode == null || root.val > previousNode.val) {
			previousNode = root;
		} else {
			return false; 
		}
		
		if (!isValidBST(root.right)) {
			return false;
		}
		
		return true;
    }

}
