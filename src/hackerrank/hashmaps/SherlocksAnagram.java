package hackerrank.hashmaps;

public class SherlocksAnagram {

    public int numOfAnagram(String str){
        int total = 0;

        for (int i = 1; i < str.length(); i++){
            int [] tempstr = new int [26];

            for (int j = i; j >= 0; j--){
                ++tempstr[str.charAt(j) - 'a'];

                for (int k = 0; k < j ; k++){
                    int [] chars = new int[26];
                    int x = k;
                    int count = 0;
                    while (count <= i - j){
                        ++chars[str.charAt(x) - 'a'];
                        x++;
                        count++;
                    }

                    boolean flag = true;

                    for (x = 0; x < 26; x++){
                        if (tempstr[x] != chars[x]){
                            flag = false;
                            break;
                        }
                    }

                    if (flag) ++total;
                }
            }
        }

        return total;
    }
}
