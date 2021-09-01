package amazon;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++){

            for(int j = i+1; j <= s.length(); j++){
                String temp = s.substring(i, j);
                if (isPalinodrome(temp)){
                    if (temp.length() > ans.length()){
                        ans = temp;
                    }
                }
            }
        }
        return ans;
    }

    public boolean isPalinodrome(String s){
        int length = s.length();

        for (int i = 0, j = length -1; i<=j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }

        return true;
    }

    public String longestPalindromefaster(String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i<s.length(); i++){
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            int len = Math.max(len1, len2);

            if (len > end - start){
                start = i - (len -1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end);
    }

    public int expandFromCenter(String s, int left, int right){
        int l = left, r = right;

        while (l >= 0 && r <= s.length() && s.charAt(l) == s.charAt(r)){
            r++;
            l--;
        }

        return r - l - 1;
    }

    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() <= 1) {
                return s;
            }
            int maxPalindromeLength = 0;
            String longestPalindrome = null;

            for (int i = 0; i < s.length(); i++) {
                int d1 = palindromeDistance(s, i, i);
                if (2 * d1 + 1 > maxPalindromeLength) {
                    maxPalindromeLength = 2 * d1 + 1;
                    longestPalindrome = s.substring(i - d1, i + d1 + 1);
                }
                int d2 = palindromeDistance(s, i, i + 1);
                if (2 * d2 + 2 > maxPalindromeLength) {
                    maxPalindromeLength = 2 * d2 + 2;
                    longestPalindrome = s.substring(i - d2, i + d2 + 2);
                }
            }
            return longestPalindrome;
        }

        private int palindromeDistance(String s, int leftMid, int rightMid) {
            int maxDistance = Math.min(leftMid, s.length() - 1 - rightMid);
            for (int i = 0; i <= maxDistance; i++) {
                if (s.charAt(leftMid - i) != s.charAt(rightMid + i)) {
                    return i - 1;
                }
            }
            return maxDistance;
        }

    }
    }
