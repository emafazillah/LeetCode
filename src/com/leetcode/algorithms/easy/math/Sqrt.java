package com.leetcode.algorithms.easy.math;

import java.util.Scanner;

public class Sqrt {
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		System.out.println(mySqrt(x));
		scanner.close();
	}
	
	public static int mySqrt(int x) {
		if(x == 0) {
			return 0;
		}
		
        if(x >= 1 && x <= 3) {
        	return 1;
        }
        
        long mid = 0;
        long left = 1;
		long right = x / 2;
		while(left <= right) {
			mid = (right + left) / 2;
			if (x == mid * mid || (mid * mid < x && (mid + 1) * (mid + 1) > x)) {
				break;
			} else if(x > mid * mid) {
				left = mid + 1;
            } else {
                right = mid - 1;
            }
		}
		
		return Integer.parseInt(Long.toString(mid));
    }

}
