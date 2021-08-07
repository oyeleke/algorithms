package elements_of_programming_interviews;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class ComputeBuildingWithSunSet {
    private static class BuildingWithHeight {
        public Integer id;
        public Integer height;

        public BuildingWithHeight(Integer id, Integer height) {
            this.id = id;
            this.height = height;
        }
    }
        public static Deque<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> sequence){
            int buildingldx = 0;
            Deque<BuildingWithHeight> buildingsWithSunset = new LinkedList();

            while (sequence.hasNext()){
                int buildingHeight = sequence.next();
                while (!buildingsWithSunset.isEmpty() && buildingHeight >= buildingsWithSunset.getLast().height){
                    buildingsWithSunset.removeLast();
                }

                buildingsWithSunset.addLast(new BuildingWithHeight(buildingldx++, buildingHeight));
            }
            return buildingsWithSunset;
        }
}
