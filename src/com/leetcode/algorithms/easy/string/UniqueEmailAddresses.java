package com.leetcode.algorithms.easy.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UniqueEmailAddresses {
	
	public static int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
		
        for(int i = 0; i < emails.length; i++) {
        	String email = emails[i].toLowerCase();
        	
        	// Local name
        	int aliasIndex = email.indexOf("@");
        	String localName = email.substring(0, aliasIndex);
        	localName = localName.replace(".", "");
        	
        	String newLocalName = "";
        	int plusSignIndex = localName.indexOf("+");
        	if(plusSignIndex == -1) {
        		newLocalName = localName;
        	} else {
        		newLocalName = localName.substring(0, plusSignIndex);
        	}
        	
        	// Domain name
        	String domainName = email.substring(aliasIndex, email.length());
        	
        	// New email
        	String newEmail = newLocalName + domainName;
        	
        	//System.out.println(newEmail);
        	
        	uniqueEmails.add(newEmail);
        }
		
		return uniqueEmails.size();
    }
	
	public static void main(String...strings) {
		Scanner scanner = new Scanner(System.in);
		List<String> emailAddresses = new ArrayList<>();
		int count = 0;
		
		while(scanner.hasNext()) {
			String input = scanner.next();
			if(input.equals("exit")) {
				break;
			} else {
				emailAddresses.add(input);
				++count;
			}
		}
		
		String[] emails = emailAddresses.toArray(new String[count]);
		
		System.out.println(numUniqueEmails(emails));
		
		scanner.close();
	}

}
