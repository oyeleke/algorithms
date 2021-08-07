package LeetCode;

import java.util.Stack;

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> enq, deq;
    public MyQueue() {
        enq = new Stack<>();
        deq = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        enq.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(deq.isEmpty()){
            while(!enq.isEmpty()){
                deq.push(enq.pop());
            }
        }

        return deq.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(deq.isEmpty()){
            while(!enq.isEmpty()){
                deq.push(enq.pop());
            }
        }
        return deq.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deq.isEmpty() && enq.isEmpty();
    }
}

