package elements_of_programming_interviews;

public class ReverseStrings {

    public String reverseWordsSlow(String s) {
        s = s.trim();
        char [] sChar = s.toCharArray();

        printChar(sChar);
        System.out.println("");
        reverse(sChar, 0, sChar.length);
        printChar(sChar);
        // reverse each word
        int start = 0, end;
        StringBuilder d = new StringBuilder();

        while((end = find(sChar, ' ', start)) != -1){
            String w = reverseString(sChar, start, end);
            d.append(w);
            d.append(' ');
            int tmpend = end;
            while(sChar[tmpend] == ' '){
                tmpend++;
            }
            end = tmpend - 1;
            start = tmpend;
        }

        d.append(reverseString(sChar, start, sChar.length));
        return d.toString();
    }

    public void reverse(char [] array, int start, int stopIndex){
        if(start >= stopIndex){
            return;
        }

        int last = stopIndex -1;

        for (int i = start; i <= start + (last - start)/2; i++){
            char tmp = array[i];
            array[i] = array[last - i + start];
            array[last - i + start] = tmp;
        }

    }

    public String reverseString(char [] array, int start, int stopIndex){
        if(start >= stopIndex){
            return "";
        }

        int last = stopIndex-1;
        StringBuilder s = new StringBuilder();
        int re = stopIndex;
        System.out.println(start+ " "+ last);
        for (int i = start; i <= last; i++){
            s.append(array[last - i + start]);
        }
        System.out.println(s.toString());
        return s.toString();
    }

    public  int find(char [] array, char c, int start){
        for (int i = start; i< array.length; i++){
            if (array[i] == c){
                System.out.println(array[i-1]);
                return i;
            }
        }

        return -1;
    }

    public void printChar(char [] array){
        for (char c : array){
            System.out.print(c);
        }
    }

    public String reverseWords(String s) {
        s = s.trim();
        String [] array = s.split("\\s");
        StringBuilder d = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--){
            if (!array[i].isEmpty()) {
                d.append(array[i]);
                d.append(" ");
            }
        }

        return d.toString().trim();
    }

    public String reverseWordsfast(String s) {
        if (s == null || s.length() == 0) return s;
        char[] str = s.toCharArray();
        int p = 0, q = 0, end = str.length - 1;
        while(end >= 0 && str[end] == ' ') --end;
        while(q <= end) {
            int start = p;
            while(q <= end && str[q] == ' ') ++q;
            while(q <= end && str[q] != ' ') {
                str[p++] = str[q++];
            }
            reversefast(str, start, p-1);
            if(q <= end) str[p++] = ' ';

        }
        reversefast(str, 0, p-1);
        return new String(str, 0, p);
    }
    private void reversefast(char[] str, int i, int j){
        for(; i < j; i++, j--) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }
}
