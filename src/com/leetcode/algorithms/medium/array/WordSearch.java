package com.leetcode.algorithms.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

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
			String[] inputArr = InputUtil.inputArr(inputs.get(i));
			map.put(i, Arrays.asList(inputArr));
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
		// Map of character of word and character location
		Map<Character, String> map = new HashMap<>();
		
		char[] charWord = word.toCharArray();
		int idx = 0;
		int count = 0;
		int i = 0;
		while (i < board.length) {
			int j = 0;
			while (j < board[i].length) {
				char b = board[i][j];
				if (idx < charWord.length && charWord[idx] == b) {
					if (map.isEmpty()) { // first character found then insert
						map.put(charWord[idx], Integer.toString(i) + "," + Integer.toString(j));
						++idx;
						++count;
					} else {
						String[] location = map.get(charWord[idx - 1]).split(",");
						int prevI = Integer.parseInt(location[0]);
						int prevJ = Integer.parseInt(location[1]);
						if (Math.abs(i - prevI) == 1 || Math.abs(j - prevJ) == 1) {
							map.put(charWord[idx], Integer.toString(i) + "," + Integer.toString(j));
							++idx;
							++count;
						} else {
							return false;
						}
					}
				}
				
				++j;
			}
			
			++i;
		}
		
		if (count != charWord.length) {
			return false;
		}
        
		return true;
    }
	
}
