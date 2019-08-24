package com.leetcode.algorithms.easy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.leetcode.util.Node;

public class NAryTreePreorderTraversal {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		Gson gson = new Gson();
		Node root = gson.fromJson(input, Node.class);
		
		// Print output
		List<Integer> output = preorder(root);
		Integer[] outputArr = output.toArray(new Integer[output.size()]);
		System.out.println(Arrays.toString(outputArr));
		
		scanner.close();
	}
	
	static List<Integer> preorder(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		
		if (root == null) {
			return list;
		}
		
		return preorder(root, list);
	}
	    
	static List<Integer> preorder(Node root, List<Integer> list) {
		list.add(root.val);
		
		for (Node node : root.children) {
			preorder(node, list);
		}
		
		return list;
	}

}
