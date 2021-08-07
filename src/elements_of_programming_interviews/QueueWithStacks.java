package elements_of_programming_interviews;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> enq = new Stack<>();
    Stack<Integer> deq = new Stack<>();

    public void enqueue(Integer x) {enq.push(x);}

    public int dequeue(){
        if (deq.isEmpty()){
            while (!enq.isEmpty()){
                deq.push(enq.pop());
            }
        }

        if (!deq.isEmpty()){
            return deq.pop();
        }

        throw new NoSuchElementException("Dequeue empty");
    }
}
