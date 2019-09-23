package com.leetcode.algorithms.easy.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class FindModeInBinarySearchTree {
	
	public static void main(String...strings) {
		// Insert input into TreeNode
		Scanner scanner = new Scanner(System.in);
		String[] inputArr = InputUtil.inputArr(scanner.next());
		
		TreeNode root = null;
		for(String input : inputArr) {
			if(!"null".equals(input)) {
				root = insert(root, Integer.parseInt(input));
			}
		}
		
		// Find the duplicate
		int[] result = findMode(root);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
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
	
	static TreeNode searchTreeNode(TreeNode root, Map<Integer, Integer> map) {
		if (map.containsKey(root.val)) {
        	int val = map.get(root.val) + 1;
        	map.put(root.val, val);
        } else {
        	map.put(root.val, 1);
        }
        
        // Search left
        if (root.left != null) {
        	root.left = searchTreeNode(root.left, map);
        }
        
        // Search right
        if (root.right != null) {
        	root.right = searchTreeNode(root.right, map);
        }
        
        return root;
	}
	
	static int[] findMode(TreeNode root) {
		if (root == null) {
			return new int[0];
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		searchTreeNode(root, map);
        
        // Get mode
		int mode = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (entry.getValue() >= mode) {
        		mode = entry.getValue();
        	}
        }
        
        // Update list
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (entry.getValue() == mode) {
        		list.add(entry.getKey());
        	}
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        	result[i] = list.get(i);
        }
        
        return result;
    }
}
