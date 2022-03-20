package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/18 23:32
 * @Description:
 */
public class LeetCode_557 {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        String[] strs = s.split(" ");
        for (String str: strs) {
            builder.append(new StringBuilder(str).reverse());
        }
        return builder.deleteCharAt(builder.length()-1).toString();
    }
}
