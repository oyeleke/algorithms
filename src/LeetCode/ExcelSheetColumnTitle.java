package LeetCode;

public class ExcelSheetColumnTitle {
        public String convertToTitle(int columnNumber) {

            StringBuilder s = new StringBuilder();

            do{
                if(columnNumber == 26){
                    s.append('Z');
                    break;
                }

                int mod = columnNumber % 26;
                System.out.println(mod);

                if(mod != 0){
                    s.append((char) ('@' + mod));
                    columnNumber /= 26;
                } else {
                    s.append('Z');
                    columnNumber = (columnNumber/26) - 1;
                }

            } while (columnNumber != 0);

            return s.reverse().toString();
        }
}
