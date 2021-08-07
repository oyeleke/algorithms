package elements_of_programming_interviews;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class  QueueWithMax<T extends Comparable<T> > {

    Queue<T> queue = new LinkedList<>();
    Deque<T>maxCandidates = new LinkedList<>();

    public void enqueue(T x){
        queue.add(x);

        while (!maxCandidates.isEmpty()){
            if (maxCandidates.getLast().compareTo(x) >= 0){
                break;
            }
            maxCandidates.removeLast();
        }
        maxCandidates.addLast(x);
    }

    public T dequeue(){
        if (!queue.isEmpty()) {
            T ret = queue.poll();
            if (ret == maxCandidates.getFirst()) {
                maxCandidates.removeFirst();
            }

            return ret;
        }
        throw new NoSuchElementException("Queue Empty");
    }

    public T max(){
        if (!maxCandidates.isEmpty()) {
            return maxCandidates.getFirst();
        }
        throw new NoSuchElementException("Queue Empty");
    }
}
