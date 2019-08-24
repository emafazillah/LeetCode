package com.leetcode.algorithms.medium.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import com.leetcode.util.InputUtil;

public class RevealCardsInIncreasingOrder {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		String[] inputs = InputUtil.inputArr(scanner.next());
		int[] deck = InputUtil.integerArr(inputs);
		
		// Print output
		System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
		
		scanner.close();
	}
	
	public static int[] deckRevealedIncreasing(int[] deck) {
		Deque<Integer> index = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            index.add(i);
        }
        
        int[] res = new int[deck.length];
        Arrays.sort(deck);
        for (int card: deck) {
            res[index.pollFirst()] = card;
            if (!index.isEmpty()) {
                index.add(index.pollFirst());
            }
        }

        return res;
    }

}
