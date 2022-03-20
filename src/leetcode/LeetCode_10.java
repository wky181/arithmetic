package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/1 23:28
 * @Description:
 */
public class LeetCode_10 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        // 如果p的第二个字符是*,那么要么直接跳过*，要么匹配一次
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            //如果不是都往后移动一步
            return first_match && isMatch(s.substring(1), p.substring(1));
        }

    }

    public boolean isMatch1(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean first_match = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < p.length() && p.charAt(j + 1) == '*'){
                    dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
                }else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
