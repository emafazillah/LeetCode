package com.leetcode.algorithms.medium;

import java.util.Arrays;
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
		int countColumn = grid[0].length;
		int countRow = grid.length;
		
		int[] leftOrRight = new int[countRow];
		for(int i = 0; i < countRow; i++) {
			int temp[] = new int[countColumn];
			for(int j = 0; j < countColumn; j++) {
				temp[j] = grid[i][j];
			}
			
			Arrays.sort(temp);
			
			leftOrRight[i] = temp[countColumn - 1];
		}
		
		//System.out.println(Arrays.toString(leftOrRight));
		
		int[] topOrBottom = new int[countColumn];
		for(int j = 0; j < countColumn; j++) {
			int temp[] = new int[countRow];
			for(int i = 0; i < countRow; i++) {
				temp[i] = grid[i][j];
			}
			
			Arrays.sort(temp);
			
			topOrBottom[j] = temp[countRow - 1];
		}
		
		//System.out.println(Arrays.toString(topOrBottom));
		
		int result = 0;
		for(int i = 0; i < countRow; i++) {
			int top = leftOrRight[i];
			
			int tempColumn[] = new int[countColumn];
			for(int j = 0; j < countColumn; j++) {
				int right = topOrBottom[j];
				
				int item = 0;
				if(right >= top) {
					item = top;
				} else {
					item = right;
				}
				
				tempColumn[j] = item;
				
				int oldGrid = grid[i][j];
				
				result += Math.abs(item - oldGrid);
			}
			
			//System.out.println(Arrays.toString(tempColumn));
		}
		
		return result;
    }

}
