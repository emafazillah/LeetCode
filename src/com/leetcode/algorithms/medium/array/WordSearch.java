package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordSearch {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String word = scanner.next();
		List<String> inputs = new ArrayList<>();
		while (scanner.hasNext()) {
			String input = scanner.next();
			if ("exit".equals(input)) {
				break;
			}
			inputs.add(input);
		}
		
		// Input into 2D-array
		Map<Integer, List<String>> map = new HashMap<>(); 
		for (int i = 0; i < inputs.size(); i++) {
			String input = inputs.get(i);
			input = input.replace("[", "");
			input = input.replace("]", "");
			String[] split = input.split(",");
			map.put(i, Arrays.asList(split));
		}
		
		char[][] board = new char[map.size()][map.get(0).size()];
		for (int i = 0; i < map.size(); i++) {
			for (int j = 0; j < map.get(i).size(); j++) {
				board[i][j] = map.get(i).get(j).charAt(0);
			}
		}
		
		// Print output
		System.out.println(exist(board, word));
		
		scanner.close();
	}

	static boolean exist(char[][] board, String word) {
		TreeNode treeNode = null;
		// Insert 2D-array into TreeNode
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				
			}
		}
        
		// TODO
		return false;
    }
	
	static void insertTreeNode(TreeNode treeNode, int val) {
		if (treeNode == null) {
			treeNode = new TreeNode(val);
		}
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode top;
	TreeNode bottom;
	
	TreeNode(int x) {
		val = x;
	}
}
