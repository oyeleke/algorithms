package LeetCode;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        char [] sChar = s.toCharArray();

        reverse(sChar, 0, sChar.length);

        // reverse each word
        int start = 0, end;
        StringBuilder d = new StringBuilder();
        while((end = find(sChar, ' ', start)) != -1){
            String w = reverseString(sChar, start, end);
            d.append(w);
            if (start != 0){
                d.append(' ');
            }
            while(sChar[end] == ' '){
                end++;
                System.out.println(end);
            }
            start = end;
        }

        d.append(reverseString(sChar, start, sChar.length));
        return d.toString();
    }

    public void reverse(char [] array, int start, int stopIndex){
        if(start >= stopIndex){
            return;
        }

        int last = stopIndex -1;

        for (int i = start; i < start + (last - start)/2; i++){
            char tmp = array[i];
            array[i] = array[last - i + start];
            array[last - i + start] = tmp;
        }

    }

    public String reverseString(char [] array, int start, int stopIndex){
        if(start >= stopIndex){
            return "";
        }

        int last = stopIndex -1;
        StringBuilder s = new StringBuilder();
        for (int i = start; i < start + (last - start)/2; i++){
            s.append(array[last - i + start]);
        }
        return s.toString();
    }

    public  int find(char [] array, char c, int start){
        for (int i = start; i< array.length; i++){
            if (array[i] == c){
                return i;
            }
        }

        return -1;
    }
}
