package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleSingleRow {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        result.add(1);
        if (rowIndex == 0){
            return result;
        }

        for (int i = 1; i < rowIndex; i++){
            result.add((int)((long)(result.get(i-1) * (rowIndex - i + 1) / i)));
        }
        result.add(1);
        return result;
    }

    public static void main(String [] args){
        List<Integer> pascalTriangle = getRow(3);
        System.out.println(pascalTriangle);
    }
}
