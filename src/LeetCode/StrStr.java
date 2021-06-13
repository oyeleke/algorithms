package LeetCode;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if(haystack.equals(needle)){
            return 0;
        }
        int n = needle.length();
        int d = haystack.length();
        for(int i = 0; i < d; i++){

            if(i + n  <= d){
                if (haystack.substring(i, i+n).equals(needle)){
                    return i;
                }
            } else {
                break;
            }
        }
        return -1;
    }
}
