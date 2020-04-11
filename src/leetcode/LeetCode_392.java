package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/2 1:13
 * @Description:
 */
public class LeetCode_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.equals("")) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (chart[i] == chars[index]) {
                index++;
                if (index == chars.length) {
                    return true;
                }
            }
        }
        return false;
    }

    //双指针法
    public boolean isSubsequence1(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int indexs = 0;
        int indext = 0;
            while (indexs < chars.length && indext < chart.length) {
                if (chars[indexs] == chart[indext]) {
                    indexs++;
                    indext++;
                } else {
                    indext++;
                }
        }
        return indexs == chars.length;
    }

}