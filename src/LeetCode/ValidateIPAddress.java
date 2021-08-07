package LeetCode;

import java.util.HashMap;

public class ValidateIPAddress {

    public String validIPAddress(String IP) {
        String Answer = "Neither";
        if (IP.contains(":") && IP.split(":").length == 8 && !IP.endsWith(":")){
            for (String s : IP.split(":")){
                if (!validateIPV6(s)){
                    return Answer;
                }
            }
            return "IPv6";
        }

        if (IP.contains(".") && IP.split("\\.").length == 4  && (IP.charAt(IP.length() - 1) != '.')){
            for (String s : IP.split("\\.")){
                if (!validateIpV4(s)){
                    return Answer;
                }
            }
            return "IPv4";
        }

        return Answer;
    }

    public boolean validateIpV4(String singleIPv4){
        if (singleIPv4.length() > 1 && singleIPv4.startsWith("0")){
            return false;
        }

        if (singleIPv4.length() > 3 || singleIPv4.isEmpty()){
            return  false;
        }

        try {
            int ipv4 = Integer.parseInt(singleIPv4);
            return (ipv4 <= 255 && ipv4 >= 0);

        } catch (NumberFormatException e){
            return false;
        }

    }

    public boolean validateIPV6(String s){
        HashMap<Character, Integer> hexaMap = new HashMap<>();
        hexaMap.put('a', 1);
        hexaMap.put('b', 1);
        hexaMap.put('c', 1);
        hexaMap.put('d', 1);
        hexaMap.put('e', 1);
        hexaMap.put('f', 1);
        hexaMap.put('A', 1);
        hexaMap.put('B', 1);
        hexaMap.put('C', 1);
        hexaMap.put('D', 1);
        hexaMap.put('E', 1);
        hexaMap.put('F', 1);

        if (s.length() >= 4 || s.isEmpty()){
            return  false;
        }

        for (char c : s.toCharArray()){
            if (Character.isLetter(c) && !hexaMap.containsKey(c)){
                return false;
            }
        }

        return true;
    }

    /*
 Base Case Check:
 - If String IP doesn't contain digits, characters of English letters, '.' and ':', it is invalid.
 - Split String IP into sections by '.' or ':'
 -
 **/
    public String validIPAddressFaster(String IP) {
        if (IP.equals("")) {
            return "Neither";
        }
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return false;
        }
        String[] sections = IP.split("\\.");
        if (sections.length != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            char[] charArray = sections[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                Character c = charArray[j];
                if (c == '0' && j == 0 && charArray.length > 1) {
                    return false;
                }
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum = sum * 10 + Character.getNumericValue(c);
            }
            if (sections[i].length() == 0) {
                return false;
            } else if (sum > 255 || sum < 0) {
                return false;
            }
            sum = 0;
        }
        return true;
    }

    private boolean isIPv6(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return false;
        }
        String[] sections = IP.split("\\:");
        if (sections.length != 8) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            if (sections[i].length() > 4 || sections[i].length() == 0) {
                return false;
            }
            for (int j = 0; j < sections[i].length(); j++) {
                if (!((sections[i].charAt(j) >= '0' && sections[i].charAt(j) <= '9') || (sections[i].charAt(j) >= 'a' && sections[i].charAt(j) <= 'f') || (sections[i].charAt(j) >= 'A' && sections[i].charAt(j) <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }
}

