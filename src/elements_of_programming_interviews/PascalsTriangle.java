package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generatePascalTriangle(int numRows){
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            List<Integer> currRows = new ArrayList<>();

            for (int j = 0; j <= i; j++){
                currRows.add((0 < j && j < i) ? pascalTriangle.get(i-1).get(j-1) + pascalTriangle.get(i-1).get(j) : 1);
            }
            pascalTriangle.add(currRows);
        }
        return pascalTriangle;
    }

    public static void main(String [] args){
        List<List<Integer>> pascalTriangle = generatePascalTriangle(5);
        for (List<Integer> list: pascalTriangle){
            System.out.println(list);
        }
    }
}
