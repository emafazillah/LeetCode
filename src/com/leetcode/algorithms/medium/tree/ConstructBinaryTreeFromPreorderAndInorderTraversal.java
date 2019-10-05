package com.leetcode.algorithms.medium.tree;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] preorder = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		int[] inorder = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Print output
		TreeNode result = buildTree(preorder, inorder);
		
		scanner.close();
	}
	
	static TreeNode buildTree(int[] preorder, int[] inorder) {
		int size = preorder.length;
		
        if (size == 0) {
        	return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        
        if (size == 1) {
        	return root;
        }

        int nodeNo = 0;
        
        for (int i = 0; i < size; ++i) {
            if (inorder[i] == preorder[1]) {
                nodeNo = i + 1;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, nodeNo + 1), 
        		Arrays.copyOfRange(inorder, 0, nodeNo));
        
        root.right = buildTree(Arrays.copyOfRange(preorder, nodeNo + 1, size), 
        		Arrays.copyOfRange(inorder, nodeNo, size - 1));
        
        return root;
    }

}
