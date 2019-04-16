package com.leetcode.algorithms;

import java.util.Scanner;

public class MaxIncreaseKeepingSkyline {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int countColumn = scanner.nextInt();
		int countRow = scanner.nextInt();
		
		int[][] grid = new int[countRow][countColumn];
		for(int i = 0; i < countRow; i++) {
			for(int j = 0; j < countColumn; j++) {
				grid[i][j] = scanner.nextInt();
			}
		}
		
		System.out.print(maxIncreaseKeepingSkyline(grid));
		
		scanner.close();
	}
	
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		
		int[] topOrBottom = new int[grid[0].length];
		for(int i = 0; i < grid[0].length; i++) {
			
		}
		
		int[] leftOrRight = new int[grid.length];
		
		return 0;
    }

}
