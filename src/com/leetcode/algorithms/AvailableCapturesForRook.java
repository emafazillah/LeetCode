package com.leetcode.algorithms;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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
		// Get Rook location
		int xAxisRook = 0; // j
        int yAxisRook = 0; // i
        boolean isRook = false;
        
		for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		String chessPiece = Character.toString(board[i][j]);
        		if("R".equals(chessPiece)) {
        			xAxisRook = j;
                	yAxisRook = i;
                	isRook = true;
                	break;
        		}
        	}
        	
        	if(isRook) {
        		break;
        	}
        }
        
        // Get Rook captures distance
		TreeMap<Integer, String> mapXPositive = new TreeMap<>();
		TreeMap<Integer, String> mapXNegative = new TreeMap<>();
        TreeMap<Integer, String> mapYPositive = new TreeMap<>();
        TreeMap<Integer, String> mapYNegative = new TreeMap<>();
        
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[i].length; j++) {
        		String chessPiece = Character.toString(board[i][j]);
        		if(!".".equals(chessPiece) && !"R".equals(chessPiece)) {
        			int x = j;
        			int y = i;
        			int distance = 0;
        			if(x == xAxisRook) {
        				distance = Math.abs(y - yAxisRook);
        				if(yAxisRook > y) {
        					mapXNegative.put(distance, chessPiece);
        				} else {
        					mapXPositive.put(distance, chessPiece);
        				}
        			} else if(y == yAxisRook) {
        				distance = Math.abs(x - xAxisRook);
        				if(xAxisRook > x) {
        					mapYNegative.put(distance, chessPiece);
        				} else {
        					mapYPositive.put(distance, chessPiece);
        				}
        			}
        		}
        	}
        }
        
        // Count Rook captures
        int result = 0;
        
        // x-axis
        for(Map.Entry<Integer, String> map : mapXPositive.entrySet()) {
        	if("p".equals(map.getValue())) {
        		++result;
        	}
        	break;
        }
        
        for(Map.Entry<Integer, String> map : mapXNegative.entrySet()) {
        	if("p".equals(map.getValue())) {
        		++result;
        	}
        	break;
        }
        
        // y-axis
        for(Map.Entry<Integer, String> map : mapYPositive.entrySet()) {
        	if("p".equals(map.getValue())) {
        		++result;
        	}
        	break;
        }
        
        for(Map.Entry<Integer, String> map : mapYNegative.entrySet()) {
        	if("p".equals(map.getValue())) {
        		++result;
        	}
        	break;
        }
        
		return result;
    }

}
