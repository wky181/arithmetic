package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/6 15:22
 * @Description:
 */
public class LeetCode_468 {
    public static void main(String[] args) {
        System.out.println("172.16.254.1".split("\\.").length);
    }
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') != -1){
            String[] splits = IP.split("\\.");
            if (splits.length != 4){
                return "Neither";
            }
            for (int i = 0; i < splits.length; i++) {
                if (!isIpv4(splits[i])){
                    return "Neither";
                }
            }
            return "Ipv4";
        }
        if (IP.indexOf(':') != -1){
            String[] splits = IP.split(":");
            if (splits.length != 8 && IP.charAt(IP.length()-1) != ':'){
                return "Neither";
            }
            for (int i = 0; i < splits.length; i++) {
                if (!isIpv6(splits[i])){
                    return "Neither";
                }
            }
            return "Ipv6";
        }
        return "Neither";
    }
    public boolean isIpv4(String s){
        try {
            int parseInt = new Integer(s);
            if (s.length() > 1 && s.charAt(0) != '0'){
                return false;
            }
            if (parseInt >=0 && parseInt <= 255){
                return true;
            }
        } catch (NumberFormatException e) {
           return false;
        }
        return false;
    }
    public boolean isIpv6(String s){
        try {
            int parseInt = Integer.parseInt(s,16);
            if (parseInt >=0 && s.charAt(0) != '-'){
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }
}
