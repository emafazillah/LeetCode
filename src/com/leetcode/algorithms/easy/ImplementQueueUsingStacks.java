package com.leetcode.algorithms.easy;

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class ImplementQueueUsingStacks {
	
	public static void main(String...strings) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		//obj.push(3);
		System.out.println("pop: " + obj.pop());
		System.out.println("peek: " + obj.peek());
		System.out.println("is empty: " + obj.empty());
	}
	
}

/**
 * Queue<Integer> queue = new LinkedList<>();
 * queue.poll(); // or queue.remove();
 * queue.peek();
 * queue.isEmpty();
 */

class MyQueue {
	
	Stack<Integer> stack = new Stack<>();
	
	/** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	if(this.stack.isEmpty()) {
    		this.stack.push(x);
    	} else {
    		Stack<Integer> tempStack = new Stack<>();
    		
//    		while(!this.stack.isEmpty()) {
//    			tempStack.push(this.stack.pop());
//    		}
//    		tempStack.push(x);
//    		this.stack = tempStack;
    		
    		tempStack.push(x);
            int size = this.stack.size();
            int count = 0;
            while(count < size) {
            	tempStack.push(this.stack.pop());
            	++count;
            }
    		
            // Update stack
            while(size > -1) {
            	this.stack.push(tempStack.pop());
            	--size;
            }
    	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(this.stack.isEmpty()) {
        	throw new RuntimeException("Stack is empty");
        }
        
        int value = this.stack.get(0);
        
        // Update stack
        Stack<Integer> tempStack = new Stack<>();
        int size = this.stack.size() - 1;
        while(size > 0) {
        	tempStack.push(this.stack.pop());
        	--size;
        }
        this.stack = tempStack;
        
        return value;
    }
    
    /** Get the front element. */
    public int peek() {
    	if(this.stack.isEmpty()) {
        	throw new RuntimeException("Stack is empty");
        }
    	
    	return this.stack.get(0);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.stack.isEmpty();
    }
    
}

