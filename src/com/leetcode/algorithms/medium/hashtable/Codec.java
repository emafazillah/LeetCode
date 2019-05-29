package com.leetcode.algorithms.medium.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Codec {
	
	private Map<String, String> map = new HashMap<>();
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		
		Codec codec = new Codec();
		String shortUrl = codec.encode(input);
		System.out.println("Short URL: " + shortUrl);
		System.out.println("Long URL" + codec.decode(shortUrl));
		
		scanner.close();
	}
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random random = new Random();
        int id = Math.abs(random.nextInt());
        String shortUrl = "http://tinyurl.com/" + Integer.toString(id);
    	map.put(longUrl, shortUrl);
    	return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String longUrl = "";
    	for(Map.Entry<String, String> entry : map.entrySet()) {
    		if(shortUrl.equals(entry.getValue())) {
    			longUrl = entry.getKey();
    		}
    	}
    	return longUrl;
    }

}
