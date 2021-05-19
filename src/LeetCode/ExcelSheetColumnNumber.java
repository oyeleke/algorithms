package LeetCode;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (char s : columnTitle.toCharArray()){

            result = (result * 26) + s - '@';
        }
        return result;
    }
}
