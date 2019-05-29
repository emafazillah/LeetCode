package com.leetcode.algorithms.easy.stack;

import java.util.Stack;

public class MinimumStack {
	public static void main(String...strings) {
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		System.out.println("get min: " + minStack.getMin());
		minStack.pop();
		System.out.println("get min: " + minStack.getMin());
		minStack.pop();
		System.out.println("get min: " + minStack.getMin());
		minStack.pop();
		System.out.println("get min: " + minStack.getMin());
	}
}

class MinStack {
	
	Stack<Integer> stack = new Stack<>();
	
	Stack<Integer> minimumStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
    	stack.push(x);
    	
    	// Update minimumStack
    	if(minimumStack.isEmpty()) {
			minimumStack.push(x);
		} else {
			int count = stack.size() - 1;
	    	while(count > -1) {
	    		if(minimumStack.peek() > stack.get(count)) {
	        		minimumStack.pop();
	        		minimumStack.push(stack.get(count));
	        	}
	    		
	    		--count;
	    	}
		}
    }
    
    public void pop() {
    	if(stack.isEmpty()) {
    		throw new RuntimeException("Stack is empty.");
    	}
    	
    	stack.pop();
    	minimumStack.pop();
        
        // Update minimumStack
        if(!stack.isEmpty()) {
        	int count = stack.size() - 1;
        	while(count > -1) {
        		if(!minimumStack.isEmpty()) {
        			if(minimumStack.peek() > stack.get(count)) {
    	        		minimumStack.pop();
    	        		minimumStack.push(stack.get(count));
    	        	}
        		} else {
        			minimumStack.push(stack.get(count));
        		}
        		
        		--count;
        	}
        }
    }
    
    public int top() {
    	if(stack.isEmpty()) {
    		throw new RuntimeException("Stack is empty.");
    	}
    	
        return stack.peek();
    }
    
    public int getMin() {
    	return minimumStack.peek();
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */