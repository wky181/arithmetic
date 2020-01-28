package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: wky233
 * @Date: 2020/1/25 22:50
 * @Description:
 */
public class LeetCode_125 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_125().isPalindrome1("race a car"));

    }
    public boolean isPalindrome(String s) {
        String p = "[A-Za-z0-9]";
        Pattern pattern = Pattern.compile(p);
        int l = 0;
        int r = s.length()-1;
        while (l < r){
            while (l < r && !pattern.matcher(""+s.charAt(l)).matches()){
                l++;
            }
            while (l < r && !pattern.matcher(""+s.charAt(r)).matches()){
                r--;
            }
            if (!(new String(""+s.charAt(l)).equalsIgnoreCase(new String(""+s.charAt(r))))){
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }

    /**
     * 运行时间太长，优化
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l < r){
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }else {
                l++;
                r--;
            }
        }
        return true;
    }
}
