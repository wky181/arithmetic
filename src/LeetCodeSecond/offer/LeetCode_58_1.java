package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/30 22:45
 * @Description:
 */
public class LeetCode_58_1 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb  = new StringBuilder();
        int len = s.length();
        for (int i = n; i < n + len ; i++) {
            sb.append(s.charAt(i % len));
        }
        return sb.toString();
    }
    public String reverseLeftWords1(String s, int n) {
        int len = s.length();
        s = s + s;
        return s.substring(n,n + len);
    }
}
