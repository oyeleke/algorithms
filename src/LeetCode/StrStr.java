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

    public int strStr2(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }

        int needleSize = 0;

        for(int i=0; i< needle.length(); i++) {
            needleSize += needle.charAt(i);
        }

        int arr[] = new int[haystack.length()];

        for(int i = 0; i< haystack.length(); i++) {
            if(i == 0) {
                arr[i] = haystack.charAt(i);
            } else {
                arr[i] = arr[i - 1] + haystack.charAt(i);
            }

            if(i >= needle.length() - 1) {
                if(i == needle.length() - 1) {
                    if(needleSize == arr[i]) {
                        boolean found = true;
                        for(int x = 0; x < needle.length(); x++) {
                            if(haystack.charAt(x) != needle.charAt(x)) {
                                found = false;
                                break;
                            }
                        }
                        if(found) {
                            return 0;
                        }
                    }
                } else {
                    if(needleSize == arr[i] - arr[i - needle.length()]) {
                        boolean found = true;
                        for(int x = 0; x < needle.length(); x++) {
                            if(haystack.charAt(x + i - needle.length() + 1) != needle.charAt(x)) {
                                found = false;
                                break;
                            }
                        }
                        if(found) {
                            return i - needle.length() + 1;
                        }

                    }
                }
            }
        }

        return -1;
    }

    public int strStr3(String haystack, String needle){

        if(haystack.length() == 0){
            return 0;
        }

        if (haystack.length() < needle.length()){
            return -1;
        }
        int needleSize = 0;

        for (char s : needle.toCharArray()){
            needleSize += s;
        }

        int [] arr = new int[haystack.length()];

        for (int i = 0; i < haystack.length(); i++){
            if (i == 0){
                arr[i] = haystack.charAt(i);
            } else {
                arr[i] = arr[i-1] + haystack.charAt(i);
            }

            if (i >= needle.length()){
                if (i == needle.length() -1){
                    if (arr[i] == needleSize){
                        boolean isFound = true;
                        for (int x = 0; x < needle.length(); x++){
                            if (haystack.charAt(x) != needle.charAt(x)){
                                isFound = false;
                            }
                        }
                        if (isFound){
                            return 0;
                        }
                    }
                } else {

                    if ((arr[i] - arr[i - needle.length()]) == needleSize){
                        boolean isFound = true;
                        for (int x = 0; x < needle.length(); x++) {
                            if (haystack.charAt(x+i - needle.length() + 1) != needle.charAt(x)){
                                isFound = false;
                                break;
                            }
                        }
                        if (isFound){
                            return i-needle.length() +1;
                        }
                        }
                }
            }
        }

        return -1;
    }
}
