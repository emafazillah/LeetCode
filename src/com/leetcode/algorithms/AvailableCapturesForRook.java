package com.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
		String xAxisRook = ""; // j
        String yAxisRook = ""; // i
		
		// location, chess pieces
		Map<String, String> chessPieces = new HashMap<>();
		
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		String key = Integer.toString(j) + Integer.toString(i);
        		String value = Character.toString(board[i][j]);
        		
        		if(!".".equals(value)) {
        			if("R".equals(value)) {
            			xAxisRook = Integer.toString(j);
                    	yAxisRook = Integer.toString(i);
            		} else {
            			chessPieces.put(key, value);
            		}
        		}
        	}
        }
        
        int result = 0;
        
        int diff = 0;
        
        for(Map.Entry<String, String> chessPiece : chessPieces.entrySet()) {
        	String coordinate = chessPiece.getKey();
        	String x = coordinate.substring(0, 1);
        	String y = coordinate.substring(1, 2);
        	String piece = chessPiece.getValue();
        	
        	int currentDiff = 0;
        	
        	if(xAxisRook.equals(x)) {
        		if(diff == 0) {
					diff = Math.abs(Integer.parseInt(y) - Integer.parseInt(yAxisRook));
				}
        		currentDiff = Math.abs(Integer.parseInt(y) - Integer.parseInt(yAxisRook));
        	}
        	
        	if(yAxisRook.equals(y)) {
        		if(diff == 0) {
					diff = Math.abs(Integer.parseInt(x) - Integer.parseInt(xAxisRook));
				}
        		currentDiff = Math.abs(Integer.parseInt(x) - Integer.parseInt(xAxisRook));
        	}
        	
        	if(xAxisRook.equals(x) && (Integer.parseInt(y) > Integer.parseInt(yAxisRook)) && (currentDiff <= diff)) {
				if("p".equals(piece)) {
					++result;
				}
				diff = currentDiff;
			} else if(xAxisRook.equals(x) && (Integer.parseInt(y) < Integer.parseInt(yAxisRook)) && (currentDiff <= diff)) {
				if("p".equals(piece)) {
					++result;
				}
				diff = currentDiff;
			} else if(yAxisRook.equals(y) && (Integer.parseInt(x) > Integer.parseInt(xAxisRook)) && (currentDiff <= diff)) {
				if("p".equals(piece)) {
					++result;
				}
				diff = currentDiff;
			} else if(yAxisRook.equals(y) && (Integer.parseInt(x) < Integer.parseInt(xAxisRook)) && (currentDiff <= diff)) {
				if("p".equals(piece)) {
					++result;
				}
				diff = currentDiff;
			}
        }
		
		return result;
    }

}
