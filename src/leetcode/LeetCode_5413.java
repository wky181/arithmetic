package leetcode;


import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/5/17 10:39
 * @Description:
 */
public class LeetCode_5413 {
    public static void main(String[] args) {

    }
    public String arrangeWords(String text) {
        char c = Character.toLowerCase(text.charAt(0));
        text = c + text.substring(1);
        String[] strings = text.split(" ");
        Arrays.sort(strings,(s1,s2) -> s1.length() - s2.length());
        String s = strings[0];
        c = Character.toUpperCase(s.charAt(0));
        s = c + s.substring(1);
        strings[0] = s ;
        StringBuilder builder = new StringBuilder();
        for (String str: strings) {
            builder.append(str).append(" ");
        }
        builder.deleteCharAt(builder.length());
        return builder.toString();

    }
}
