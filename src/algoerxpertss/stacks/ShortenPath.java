package algoerxpertss.stacks;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ShortenPath {
    public static String shortenPath(String path) {
        // Write your code here;

        if (path.isEmpty()){
            return path;
        }
        Deque<String> deque = new LinkedList<>();
        if (path.startsWith("/")){
            deque.addFirst("/");
        }
        for(String fol: path.split("/")){
            if (fol.equals("..")){
                if (deque.isEmpty() || deque.peekFirst().equals("..")){
                    deque.addFirst(fol);
                } else {
                    if (deque.peekFirst().equals("/")){
                        continue;
                    }
                    deque.removeFirst();
                }
            } else if(!fol.equals(".") && !fol.isEmpty()){
                deque.addFirst(fol);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (!deque.isEmpty()){
            Iterator<String> it = deque.descendingIterator();
            String prev = it.next();
            builder.append(prev);
            while (it.hasNext()){
                if (!prev.equals("/")){
                    builder.append("/");
                }
                prev = it.next();
                builder.append(prev);
            }
        }


        return builder.toString();
    }
}
