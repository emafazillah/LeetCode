package com.leetcode.algorithms.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class RevealCardsInIncreasingOrder {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		List<Integer> inputs = new ArrayList<>();
		while(scanner.hasNext()) {
			String input = scanner.next();
			if("exit".equals(input)) {
				break;
			}
			inputs.add(Integer.parseInt(input));
		}
		
		// Print output
		int[] deck = new int[inputs.size()];
		for(int i = 0; i < deck.length; i++) {
			deck[i] = inputs.get(i);
		}
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
