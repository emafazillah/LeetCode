package com.leetcode.algorithms.easy.binarysearch;

import java.util.Scanner;

public class Sqrt {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println(mySqrt(x));
		scanner.close();
	}
	
	public static int mySqrt(int x) {
        if(x == 1) {
        	return x;
        }
        
        long mid = 0;
        long left = 1;
		long right = x / 2;
		while(left <= right) {
			mid = left + (right + left) / 2;
			//System.out.println("mid: " + mid);
			if (x == mid * mid) {
				break;
			} else if(x > mid * mid) {
				left = mid + 1;
				//System.out.println("left: " + left);
            } else {
                right = mid - 1;
                //System.out.println("right: " + right);
            }
		}
		
		return Integer.parseInt(Long.toString(mid));
    }

}
