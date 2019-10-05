package com.leetcode.algorithms.medium.tree;

import java.util.Arrays;
import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int[] pre = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		int[] post = InputUtil.integerArr(InputUtil.inputArr(scanner.next()));
		
		// Print output
		TreeNode result = constructFromPrePost(pre, post);
		
		scanner.close();
	}
	
	static TreeNode constructFromPrePost(int[] pre, int[] post) {
		int size = pre.length;
		
        if (size == 0) {
        	return null;
        }
        
        TreeNode root = new TreeNode(pre[0]);
        
        if (size == 1) {
        	return root;
        }

        int nodeNo = 0;
        
        for (int i = 0; i < size; ++i) {
            if (post[i] == pre[1]) {
                nodeNo = i + 1;
            }
        }

        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, nodeNo + 1), Arrays.copyOfRange(post, 0, nodeNo));
        
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, nodeNo + 1, size), Arrays.copyOfRange(post, nodeNo, size - 1));
        
        return root;
    }

}
