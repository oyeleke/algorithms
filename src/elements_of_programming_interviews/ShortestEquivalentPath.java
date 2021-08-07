package elements_of_programming_interviews;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ShortestEquivalentPath {

    public static String shortestEquivalentPath(String path) {
        if (path.equals("")){
            throw new IllegalArgumentException("it didn't happen");
        }

        Deque<String> pathNames = new LinkedList<>();

        if (path.startsWith("/")){
            pathNames.addFirst("/");
        }

        for (String token: path.split("/")){
            if (token.equals("..")){
                if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")){
                    pathNames.addFirst(token);
                } else {
                    if (pathNames.peekFirst().equals("/")){
                        throw new IllegalArgumentException("it didn't happen");
                    }
                    pathNames.removeFirst();
                }
            } else if (!token.isEmpty() || !token.equals(".")){//its a path name
                pathNames.addFirst(token);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (!pathNames.isEmpty()){
            Iterator<String>it = pathNames.descendingIterator();
            String prev = it.next();
            builder.append(prev);
            while (it.hasNext()){
                if(!prev.equals("/")){
                    builder.append("/");
                }

                prev = it.next();
                builder.append(prev);
            }
        }
        return builder.toString();
    }

    public static String shortestEquivalentPathFast(String path) {
        ArrayDeque<String> dq = new ArrayDeque<>();
        int i = 0;
        while(i < path.length()){
            StringBuilder sb = new StringBuilder();

            while(i < path.length() && path.charAt(i) == '/') i++;

            int dot = 0;
            while(dot <= 1 && i < path.length() && path.charAt(i) == '.'){
                dot++;
                sb.append(path.charAt(i));
                i++;
            }

            if (i == path.length() || path.charAt(i) != ','){
                if (dot == 1) continue;
                else if (dot == 2){
                    if (!dq.isEmpty()) dq.removeLast();
                    continue;
                }
            }

            while (i < path.length() && path.charAt(i) != '/'){
                sb.append(path.charAt(i));
                i++;
            }

            if (sb.length() > 0) dq.addLast(sb.toString());
        }

        StringBuilder sb = new StringBuilder();
        if (dq.isEmpty()) return "/";
        for (int j = 0; j< dq.size(); j++){
            sb.append("/").append(dq.removeLast());
        }

        System.out.print(dq);
        return sb.toString();
    }

    public String simplifyPathleet(String path) {
        if(path == "" || path == null ){
            return path;
        }

        Deque<String>pathNames = new LinkedList<>();

        if (path.startsWith("/")){
            pathNames.addFirst("/");
        }

        for(String token : path.split("/")){
            if(token.equals("..")){
                if(pathNames.isEmpty() || pathNames.peekFirst().equals("..")){
                    System.out.println("first "+ token);
                    pathNames.addFirst(token);
                } else {
                    System.out.println("first "+ token);
                    if(pathNames.peekFirst().equals("/")){
                        continue;
                    }
                    pathNames.removeFirst();
                }
            } else if(!token.isEmpty() && !token.equals(".")){
                System.out.println("second "+ token);
                pathNames.addFirst(token);
            }
        }

        StringBuilder result = new StringBuilder();

        // if(pathNames.peekFirst().equals("..")){
        //     pathNames.removeFirst();
        // }

        if(!pathNames.isEmpty()){
            Iterator<String>it = pathNames.descendingIterator();
            String prev = it.next();
            result.append(prev);
            while(it.hasNext()){
                if(!prev.equals("/")){
                    result.append("/");
                }
                prev = it.next();
                result.append(prev);
            }
        } else {
            result.append("/");
        }
        return result.toString();
    }

    }
