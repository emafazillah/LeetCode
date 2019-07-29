package com.leetcode.algorithms.easy.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindModeInBinarySearchTree {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		Scanner scanner = new Scanner(System.in);
		String inputs = scanner.next();
		inputs = inputs.replace("[", "");
		inputs = inputs.replace("]", "");
		String[] inputArr = inputs.split(",");
		
		TreeNode root = null;
		for(String input : inputArr) {
			if(!"null".equals(input)) {
				root = insert(root, Integer.parseInt(input));
			}
		}
		
		// Find the duplicate
		findMode(root);
		
		scanner.close();
	}
	
	static TreeNode insert(TreeNode root, int input) {
		if(root == null) {
			root = new TreeNode(input);
		} else {
			if(root.val > input) {
				root.left = insert(root.left, input);
			} else {
				root.right = insert(root.right, input);
			}
		}
		
		return root;
	}
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	static int[] findMode(TreeNode root) {
		if(root == null) {
			return null;
		}
		
        if(map.isEmpty()) {
        	map.put(root.val, 1);
        } else {
        	
        }
        
        // TODO
        return null;
    }
}
