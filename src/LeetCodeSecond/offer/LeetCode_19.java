package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/18 15:44
 * @Description:
 */
public class LeetCode_19 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] 表示s的前i个和p的前j个能否匹配
        boolean[][] dp = new boolean[m+1][n+1];
        // i 和 j为0表示为空的情况
        for (int i = 0; i <= m ; i++) {
            for (int j = 0; j <= n ; j++) {
                // 如果正则表达式为空的情况 一共分为正则表达式空和非空两种情况
                if (j == 0){
                    dp[i][j] = i == 0;
                }else {
                    //非空正则分为两种情况 * 和 非*
                    if (p.charAt(j-1) != '*'){
                        if (i > 0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')){
                            dp[i][j] = dp[i-1][j-1];
                        }
                    }else {
                        //碰到 * 了，分为看和不看两种情况
                        //先不看 正则向前移动两位  因为s.charAt(i-1) != p.charAt(j-2)
                        if (j >= 2){
                            dp[i][j] = dp[i][j-2];
                        }
                        //看
                        if (i>=1 && j>=2 && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')){
                            // 不一定非要看，看或不看其中一个为true 就表示表示s的前i个和p的前j个能匹配
                            dp[i][j] |=  dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
