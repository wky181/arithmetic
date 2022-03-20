package LeetCodeSecond;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/6/15 14:51
 * @Description:
 */
public class LeetCode_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String per = strs[0];
        for (int i = 1; i < strs.length ; i++) {
           per = findPer(per, strs[i]);
        }
        if (per.equals("")){
            return "";
        }
        return per;
    }

    private String findPer(String per, String str) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(per.length(), str.length());
        for (int i = 0; i < len; i++) {
            if (per.charAt(i) == str.charAt(i)){
                sb.append(per.charAt(i));
            }
        }
        return sb.toString();
    }
}
