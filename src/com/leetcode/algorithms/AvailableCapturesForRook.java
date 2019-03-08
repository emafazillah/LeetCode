package com.leetcode.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// LATER
public class AvailableCapturesForRook {
	
	public static void main(String...strings) {
		// Input
		Scanner scanner = new Scanner(System.in);
		int columns = scanner.nextInt();
		int rows = scanner.nextInt();
		char[][] board = new char[rows][columns];
		for(int x = 0; x < rows; x++) {
			for(int y = 0; y < columns; y++) {
				String input = scanner.next();
				board[x][y] = input.charAt(0);
			}
		}
		
		System.out.println(numRookCaptures(board));
		
		scanner.close();
	}
	
	public static int numRookCaptures(char[][] board) {
		// location, chess pieces
		Map<String, String> chessPieces = new HashMap<>();
		Map<String, String> rook = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		String key = Integer.toString(j) + Integer.toString(i);
        		String value = Character.toString(board[i][j]);
        		
        		if(!".".equals(value)) {
        			chessPieces.put(key, value);
        			
        			if("R".equals(value)) {
            			rook.put(key, value);
            		}
        		}
        	}
        }
        
        String xAxisRook = ""; // j
        String yAxisRook = ""; // i
        for(Map.Entry<String, String> r : rook.entrySet()) {
        	String coordinate = r.getKey();
        	xAxisRook = coordinate.substring(0, 1);
        	yAxisRook = coordinate.substring(1, 2);
        }
        
        Set<String> count = new HashSet<>();
        
        for(Map.Entry<String, String> chessPiece : chessPieces.entrySet()) {
        	String coordinate = chessPiece.getKey();
        	String x = coordinate.substring(0, 1);
        	String y = coordinate.substring(1, 2);
        	String piece = chessPiece.getValue();
        	if("p".equals(piece)) {
        		if(xAxisRook.equals(x) || yAxisRook.equals(y)) {
        			if(xAxisRook.equals(x) && (Integer.parseInt(y) > Integer.parseInt(yAxisRook))) {
        				count.add("+Y");
        			} else if(xAxisRook.equals(x) && (Integer.parseInt(y) < Integer.parseInt(yAxisRook))) {
        				count.add("-Y");
        			} else if(yAxisRook.equals(y) && (Integer.parseInt(x) > Integer.parseInt(xAxisRook))) {
        				count.add("+X");
        			} else if(yAxisRook.equals(y) && (Integer.parseInt(x) < Integer.parseInt(xAxisRook))) {
        				count.add("-X");
        			}
        		}
        	}
        }
		
		return count.size();
    }

}
