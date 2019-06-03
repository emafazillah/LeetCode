package com.leetcode.algorithms.medium.binarysearch;

import java.util.Scanner;

public class TimeMap {
	
	/** Initialize your data structure here. */
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        
    }
    
    public String get(String key, int timestamp) {
    	return "";
    }
    
    public static void main(String...strings) {
    	// Input
    	Scanner scanner = new Scanner(System.in);
    	String key = scanner.next();
    	String value = scanner.next();
    	int timestamp = scanner.nextInt();
    	
    	// Your TimeMap object will be instantiated and called as such:
    	TimeMap obj = new TimeMap();
    	obj.set(key, value, timestamp);
    	String param_2 = obj.get(key, timestamp);
    	
    	System.out.print(param_2);
    	
    	scanner.close();
    }
    
}
