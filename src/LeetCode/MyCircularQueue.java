package LeetCode;

public class MyCircularQueue {
    int head = 0, tail = 0, numQueueElements = 0;
    int [] entries;
    public MyCircularQueue(int k) {
        entries = new int [k];
    }

    public boolean enQueue(int value) {
        if(numQueueElements < entries.length){
            entries[tail] = value;
            tail = (tail + 1) % entries.length;
            ++numQueueElements;
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        entries[head] = -1;
        head = (head + 1) % entries.length;
        --numQueueElements;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return entries[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int getTail = tail - 1;
        if(getTail < 0){
            return entries[getTail + entries.length];
        } else {
            return entries[getTail];
        }
    }

    public boolean isEmpty() {
        return numQueueElements == 0;
    }

    public boolean isFull() {
        return numQueueElements == entries.length;
    }
}
