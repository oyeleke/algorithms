package elements_of_programming_interviews;

import java.util.Deque;
import java.util.LinkedList;

public class StackE {

    private static class MaxWithCount{
        int max, count;

        public MaxWithCount(int max, int count) {
            this.max = max;
            this.count = count;
        }
    }


    private Deque<Integer> elements = new LinkedList<>();
    private Deque<MaxWithCount> cachedElementsWithCount = new LinkedList<>();

    public boolean empty(){
        return elements.isEmpty();
    }

    public Integer max(){
        if (empty()){
            throw new IllegalArgumentException("max(): empty stack");
        }

        return cachedElementsWithCount.peekFirst().max;
    }

    public Integer pop(){
        if (empty()){
            throw new IllegalArgumentException("pop(): empty stack");
        }
        int poppedItem = elements.removeFirst();
        if (poppedItem == cachedElementsWithCount.peekFirst().max){
            cachedElementsWithCount.peekFirst().count = cachedElementsWithCount.peek().count - 1;
            if (cachedElementsWithCount.peekFirst().count == 0){
                cachedElementsWithCount.removeFirst();
            }
        }
        return poppedItem;
    }

    public void push(Integer e){

        elements.addFirst(e);
        if (!cachedElementsWithCount.isEmpty()){
            if (e == cachedElementsWithCount.peekFirst().max){
                cachedElementsWithCount.peekFirst().count = cachedElementsWithCount.peekFirst().count + 1;
            } else if (e > cachedElementsWithCount.peekFirst().max){
                cachedElementsWithCount.addFirst(new MaxWithCount(e, 1));
            }
        } else {
            cachedElementsWithCount.addFirst(new MaxWithCount(e, 1));
        }
    }
}
