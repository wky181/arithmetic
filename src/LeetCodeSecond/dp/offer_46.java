package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/6/12 10:13
 * @Description:
 */
public class offer_46 {
    public int translateNum(int num) {
        String sr = String.valueOf(num);
        if (sr.length() < 2){
            return sr.length();
        }
        char[] arrays = sr.toCharArray();
        int[] dp = new int[arrays.length];
        dp[0] = 1;
        for (int i = 1; i < arrays.length  ; i++) {
            dp[i] = dp[i-1];
            num = (arrays[i-1] - '0') * 10 + (arrays[i] - '0');
            if (num > 9 && num < 26){
                if (i - 2 < 0){
                    dp[i]++;
                }else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[arrays.length-1];
    }
}
