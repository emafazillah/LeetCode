package com.leetcode.algorithms.medium.tree;

import java.util.Scanner;

import com.leetcode.util.InputUtil;
import com.leetcode.util.TreeNode;

/**
 * 
 * @author ema
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * 
 */
public class MaximumBinaryTree {
	
	static TreeNode constructMaximumBinaryTree(int[] nums) {
        return insertTreeNode(nums, 0, nums.length - 1);    
    }
    
    static TreeNode insertTreeNode(int[] nums, int start, int end){
        if (start > end) {
            return null;
        }
        
        int maxValue = nums[start];
        int maxPosition = start;
        
        for(int i = start; i <= end; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxPosition = i;
            }    
        }
        
        TreeNode node  = new TreeNode(maxValue);
        
        node.left = insertTreeNode(nums, start, maxPosition - 1);
        node.right = insertTreeNode(nums, maxPosition + 1, end);
        
        return node;
    }
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] nums = InputUtil.integerArr(inputs);
		
		// Contruct maximum binary tree and print output
		TreeNode tree = constructMaximumBinaryTree(nums);		
		
		scanner.close();
	}
	
}
