package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/6/20 21:02
 * @Description:
 */
public class LeetCode_10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //s的前i个和p的前j个是否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        for (int i = 0; i <= s.length() ; i++) {
            for (int j = 0; j <= p.length() ; j++) {
                //分两种情况 如果正则为空和不为空
                if (j == 0){
                    dp[i][j] = i == 0;
                }else {
                    // 如果最后一位不是*
                    if ( p.charAt(j-1) != '*'){
                        if (i > 0 && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else {
                        // 直接让表达式前移两位看是否匹配(失配的情况)
                        if (j >= 2){
                            dp[i][j] = dp[i][j-2];
                        }
                        if (i > 0 && j >= 2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-1) == '.')){
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }
}
