package com.leetcode.algorithms.easy.binarysearch;

import java.util.Scanner;

public class FirstBadVersion extends VersionControl {
	
	public static int firstBadVersion(int n) {
		int low = 1;
        int high = n;
        int result = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(firstBadVersion(n));
		scanner.close();
	}
	
}
