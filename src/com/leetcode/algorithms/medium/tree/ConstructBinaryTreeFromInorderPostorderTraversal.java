package com.leetcode.algorithms.medium.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromInorderPostorderTraversal {
	
	static int post;
	
	static TreeNode buildTree(int[] inorder, int[] postorder) {
		post = postorder.length - 1;
	    Map<Integer,Integer> map = new HashMap<>();
	    for (int i = 0; i < inorder.length; i++) {
	    	map.put(inorder[i], i);
	    }
	    
	    return tree(0, inorder.length - 1, postorder, map);
	}
	
	static TreeNode tree(int start, int end, int[] postorder, Map<Integer,Integer> map){
	    if (start > end) {
	    	return null;
	    }
	    
	    TreeNode root = new TreeNode(postorder[post]);
	    
	    int r = post;
	    
	    post--;
	    
	    root.right = tree(map.get(postorder[r]) + 1, end, postorder, map);
	    
	    root.left = tree(start, map.get(postorder[r]) - 1, postorder,map);
	    
	    return root;
	}
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] inorder = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		int[] postorder = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Print output
		TreeNode result = buildTree(inorder, postorder);
		
		scanner.close();
	}

}
