package elements_of_programming_interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrecisionMultiply {


    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2){
        final int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result =  new ArrayList<>(Collections.nCopies(num1.size()+ num2.size(), 0));

        for (int i = num1.size() -1; i >=0 ; --i){
            for (int j = num2.size() - 1; j>= 0; --j){
                result.set(j+i+1, result.get(j+i+1) + (num1.get(i)* num2.get(j)));
                result.set(j+i, result.get(i+j+1)%10 + result.get(j+i));
                result.set(j+i+1, result.get(j+i+1)/10 );
            }
        }

        int leading0 = 0;
        while(leading0 < result.size() && result.get(leading0) == 0){
            leading0 ++;
        }
        result = result.subList(leading0, result.size());

        if (result.isEmpty()){
            return Collections.singletonList(0);
        }
        result.set(0, result.get(0) * sign);
        return result;
    }
}