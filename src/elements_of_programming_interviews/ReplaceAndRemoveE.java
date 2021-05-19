package elements_of_programming_interviews;

public class ReplaceAndRemoveE {
    public static int replaceAndRemove(int size, char[] s) {
        int writeIdx = 0 , acount = 0;

        for (int i = 0; i < s.length; i++){
            if (s[i] != 'b'){
                s[writeIdx++] = s[i];
            }

            if (s[i] == 'a'){
                acount++;
            }
        }

        int curIdx = writeIdx - 1;
        writeIdx = writeIdx + acount - 1;

        int finalSize = writeIdx + 1;

        while(curIdx >= 0){
            if (s[curIdx] == 'a'){
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                s[writeIdx--] = s[curIdx];
            }
            curIdx--;
        }

        return finalSize;
    }

}
