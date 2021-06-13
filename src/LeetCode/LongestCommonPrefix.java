package LeetCode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        String ret = strs[0];

        for (int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(ret) != 0){
                ret = ret.substring(0, ret.length() - 1);
                if (ret.isEmpty()){
                    return "";
                }
            }
        }

        return ret;
    }

    public String longestCommonPrefixSlow(String[] strs) {
        // find shortest StringFirst;
        if(strs.length < 1){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }
        String output = "";
        int max = Integer.MAX_VALUE;
        String ss = "";

        for(String str : strs){
            if(str.length() < max){
                max = str.length();
                ss = str;
            }
        }

        for(int i = 1; i<= max; i++){
            boolean isComplete = false;
            String cursub = ss.substring(0,i);
            for(int j = 0; j < strs.length; j++){
                if(!strs[j].startsWith(cursub)){
                    isComplete = false;
                    break;
                }
                isComplete = true;
            }


            if(isComplete){
                output =  cursub;
            } else {
                break;
            }
        }
        return output;
    }
}
