package algoerxpertss.stacks;

import java.util.*;

import static com.sun.tools.attach.VirtualMachine.list;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        if (buildings == null ||buildings.length == 0 ) {
            return new ArrayList<Integer>();
        }

        Deque<Integer> buildingStack = new LinkedList<Integer>();
        if (direction.toLowerCase().equals("east")){
            for (int i = 0; i < buildings.length; i++){
                while (!buildingStack.isEmpty() && buildings[i] >= buildings[buildingStack.peekFirst()]){
                    buildingStack.removeFirst();
                }
                buildingStack.addFirst(i);
            }
        } else if(direction.toLowerCase().equals("west")){
            for (int i = 0; i < buildings.length; i++){
                if (buildingStack.isEmpty()){
                    buildingStack.addFirst(i);
                } else {
                    if (buildings[buildingStack.peekFirst()] < buildings[i]){
                        buildingStack.addFirst(i);
                    }
                }
            }
        }
        // Write your code here.
        ArrayList<Integer> results = new ArrayList<>(buildingStack);
        Collections.reverse(results);
        return results ;
    }
}
