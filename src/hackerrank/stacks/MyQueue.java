package hackerrank.stacks;

import java.util.Stack;

public class MyQueue<T> {

    Stack<T> enq, deq;

    public MyQueue() {
        enq = new Stack<>();
        deq = new Stack<>();
    }

    public void enqueue(T value) {
        enq.push(value);
    }

    public T dequeue() {
        if (deq.isEmpty()){
            while(!enq.isEmpty()){
                deq.push(enq.pop());
            }
        }

        if (!deq.isEmpty()){
            return deq.pop();
        } else {
            return null;
        }
    }

    public T peek() {
        if (deq.isEmpty()) {
            while (!enq.isEmpty()) {
                deq.push(enq.pop());
            }
        }


        if (!deq.isEmpty()){
            return deq.peek();
        } else {
            return null;
        }
    }


}
