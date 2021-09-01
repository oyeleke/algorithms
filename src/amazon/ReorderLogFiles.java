package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class
ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> myComp = (log1, log2) -> {
            // split each log into two parts: <identifier, content>
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

            // case 1). both logs are letter-logs
            if (!isDigit1 && !isDigit2) {
                // first compare the content
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0)
                    return cmp;
                // logs of same content, compare the identifiers
                return split1[0].compareTo(split2[0]);
            }

            // case 2). one of logs is digit-log
            if (!isDigit1 && isDigit2)
                // the letter-log comes before digit-logs
                return -1;
            else if (isDigit1 && !isDigit2)
                return 1;
            else
                // case 3). both logs are digit-log
                return 0;
        };

        Arrays.sort(logs, myComp);
        return logs;
    }

    public String[] reorderLogFiles2(String[] logs) {
        Comparator<String> logComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] split1 = o1.split(" ", 2);
                String [] split2 = o2.split(" ", 2);

                boolean isLetter1 = Character.isLetter(split1[1].charAt(0));
                boolean isLetter2 = Character.isLetter(split2[1].charAt(0));

                if (isLetter1 && isLetter2){

                    int cmp = split1[1].compareTo(split2[1]);

                    if (cmp != 0) return cmp;

                    return split1[0].compareTo(split2[0]);
                }

                if (!isLetter1 && isLetter2){
                    return 1;
                } else if(isLetter1 && !isLetter2){
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        Arrays.sort(logs, logComparator);
        return logs;
    }

    public String[] reorderLogFiles3(String[] logs){
        String[] ans = new String[logs.length];
        ArrayList<String> letterLogs = new ArrayList<>();
        ArrayList<String> digitLog = new ArrayList<>();

        for (String s: logs){
            if (isLetterlog(s)){
                letterLogs.add(s);
            } else {
                digitLog.add(s);
            }
        }

        Comparator<String> logconp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String [] let1 = o1.split(" ", 2);
                String [] let2 = o2.split(" ", 2);

                int cmp = let1[1].compareTo(let2[1]);
                if (cmp != 0) return cmp;
                return let1[0].compareTo(let2[0]);
            }
        };

        letterLogs.sort(logconp);

        for (int i = 0; i< letterLogs.size(); i++){
            ans[i] = letterLogs.get(i);
        }

        for (int i = letterLogs.size(), j = 0; i< letterLogs.size() + digitLog.size() && j < digitLog.size(); i++, j++){
            ans[i] = digitLog.get(j);
        }

        return ans;
    }

    public boolean isLetterlog(String log){
        String [] split = log.split(" ", 2);

        return Character.isLetter(split[1].charAt(0));
    }
}
