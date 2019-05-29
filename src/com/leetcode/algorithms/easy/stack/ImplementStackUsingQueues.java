package com.leetcode.algorithms.easy.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	
	public static void main(String...strings) {
		MyStack obj = new MyStack();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		System.out.println("top: " + obj.top());
		System.out.println("pop: " + obj.pop());
		System.out.println("top: " + obj.top());
		System.out.println("pop: " + obj.pop());
		System.out.println("top: " + obj.top());
		System.out.println("pop: " + obj.pop());
		System.out.println("is empty: " + obj.empty());
	}

}

class MyStack {
	
	Queue<Integer> queue = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(this.queue.isEmpty()) {
        	this.queue.add(x);
        } else {
        	Queue<Integer> tempQueue = new LinkedList<>();
        	Integer[] tempArray;
        	
        	// Create temporary queue
        	int count = queue.size() - 1;
        	tempArray = this.queue.toArray(new Integer[count]);
        	while(count > -1) {
        		tempQueue.add(tempArray[count]);
        		this.queue.remove(tempArray[count]);
        		--count;
        	}
        	
        	tempQueue.add(x);
        	
        	// Update queue
        	count = tempQueue.size() - 1;
        	tempArray = tempQueue.toArray(new Integer[count]);
        	while(count > -1) {
        		this.queue.add(tempArray[count]);
        		--count;
        	}
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(this.queue.isEmpty()) {
        	throw new RuntimeException("Queue is empty");
        }
    	
    	int value = this.queue.peek();
        
    	// Create temporary queue
        Queue<Integer> tempQueue = new LinkedList<>();
        int count = 0;
        int size = this.queue.size();
        while(count < size) {
        	if(count > 0) {
        		tempQueue.add(this.queue.poll());
        	} else {
        		this.queue.poll();
        	}
        	
        	++count;
        }
        
        // Update queue
        this.queue = tempQueue;
        
        return value;
    }
    
    /** Get the top element. */
    public int top() {
        if(this.queue.isEmpty()) {
        	throw new RuntimeException("Queue is empty");
        }
        
        return this.queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.queue.isEmpty();
    }
    
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
