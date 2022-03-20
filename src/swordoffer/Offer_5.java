package swordoffer;

/**
 * @Author: wky233
 * @Date: 2020/8/27 8:59
 * @Description:
 */
public class Offer_5 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' '){
                sb.append("20%");
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
