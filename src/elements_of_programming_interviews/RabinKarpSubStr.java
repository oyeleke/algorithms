package elements_of_programming_interviews;

public class RabinKarpSubStr {

    public static int rabinKarp(String t, String s) {
        if (t.length() < s.length()){
            return -1;
        }
        int Base = 26;
        int thash = 0, shash = 0, powerS = 0;
        for (int i = 0; i < s.length(); i++){
            powerS = i > 0 ? powerS * Base : 1;
            shash = shash * Base + s.charAt(i);
            thash = thash * Base + t.charAt(i);
        }

        for (int i = s.length() ; i < t.length(); i++){

            if (thash == shash && t.substring(i - s.length(), i).equals(s)){
                return (i-s.length());
            }

            thash -= t.charAt(i-s.length()) * powerS;
            thash = thash * Base +t.charAt(i);
        }

        if (thash == shash && t.substring(t.length() - s.length()).equals(s)){
            return t.length() - s.length();
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(rabinKarp("ccchdfghdjsicncrmcckkencccchdf", "hdf"));
    }
}


