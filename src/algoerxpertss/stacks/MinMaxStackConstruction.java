package algoerxpertss.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class MinMaxStackConstruction {
    static class MinWithCount {
        int min, count;
        public MinWithCount(int min, int count){
            this.min = min;
            this.count = count;
        }
    }

    static class MaxWithCount {
        int max, count;
        public MaxWithCount(int max, int count){
            this.max = max;
            this.count = count;
        }
    }

    static class MinMaxStack {
        Deque<MaxWithCount> maxWithCountList = new LinkedList<>();
        Deque<MinWithCount>minWithCountList = new LinkedList<>();
        Deque<Integer> elementsStack = new LinkedList<>();

        public int peek() {
            // Write your code here.

            if(empty()){
                return -1;
            } else {
                return elementsStack.peekLast();
            }
        }

        public int pop() {
            // Write your code here.
            if(empty()){
                return -1;
            } else {
                int element = elementsStack.removeLast();
                if (element == maxWithCountList.peekLast().max){
                    maxWithCountList.peekLast().count = maxWithCountList.peekLast().count - 1;
                } else if(element == minWithCountList.peekLast().min) {
                    minWithCountList.peekLast().count = minWithCountList.peekLast().count - 1;
                }

                if (maxWithCountList.peekLast().count == 0){
                    maxWithCountList.removeLast();
                }
                if (minWithCountList.peekLast().count == 0){
                    minWithCountList.removeLast();
                }

                return element;
            }
        }

        public void push(Integer number) {
            // Write your code here.
            elementsStack.addLast(number);
            if (!maxWithCountList.isEmpty()){
                if (number == maxWithCountList.peekLast().max){
                    maxWithCountList.peekLast().count = maxWithCountList.peekLast().count + 1;
                } else if(number > maxWithCountList.peekLast().max){
                    maxWithCountList.addLast(new MaxWithCount(number, 1));
                }
            } else {
                maxWithCountList.addLast(new MaxWithCount(number, 1));
            }

            if (!minWithCountList.isEmpty()){
                if (number == minWithCountList.peekLast().min){
                    minWithCountList.peekLast().count = minWithCountList.peekLast().count + 1;
                } else if(number < minWithCountList.peekLast().min){
                    minWithCountList.addLast(new MinWithCount(number, 1));
                }
            } else {
                maxWithCountList.addLast(new MaxWithCount(number, 1));
            }
        }

        public int getMin() {
            // Write your code here.
            if (elementsStack.isEmpty() && minWithCountList.isEmpty()) {
                return -1;
            } else {
               return minWithCountList.peekLast().min;
            }
        }

        public int getMax() {
            // Write your code here.
            if (elementsStack.isEmpty() && maxWithCountList.isEmpty()) {
                return -1;
            } else {
                return maxWithCountList.peekLast().max;
            }
        }

        public boolean empty() {
            return elementsStack.isEmpty();
        }
    }
}
