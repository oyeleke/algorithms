package elements_of_programming_interviews;

public class TestPalindromicity {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() -1;
        char [] str = s.toCharArray();
        while(i<j){

            while(!Character.isLetterOrDigit(s.charAt(i)) && i < j){
                i++;
            }

            while(!Character.isLetterOrDigit(s.charAt(j)) && i < j){
                j--;
            }

            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        System.gc();
        return true;
    }
}
