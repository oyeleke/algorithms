package elements_of_programming_interviews;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CircularQueue {

    int head = 0, tail = 0, numQueueElements = 0;
    int SCALE_FACTOR = 2;
    int[] entries;

    public CircularQueue(int capacity) {
        entries = new int[capacity];
    }

    public void enqueue(int x) {
        if (numQueueElements == entries.length) {
            // rearrange queue
            Collections.rotate(Arrays.asList(entries), -head);
            head = 0;
            tail = numQueueElements;
            // increase array by allocated factor
            entries = Arrays.copyOf(entries, numQueueElements* SCALE_FACTOR);
        }

        entries[tail] = x;
        tail = (tail + 1) % entries.length;
        ++numQueueElements;
    }

    public int dequeue(){
        if (numQueueElements != 0){
            -- numQueueElements;
            int x = entries[head];
            head = (head + 1) % entries.length;
            return x;
        }
        throw new NoSuchElementException("Tried to deque an empty queue");
    }

    public int size(){
        return numQueueElements;
    }
}
