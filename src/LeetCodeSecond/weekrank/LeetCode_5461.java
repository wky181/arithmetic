package LeetCodeSecond.weekrank;

/**
 * @Author: wky233
 * @Date: 2020/7/12 10:33
 * @Description:
 */
public class LeetCode_5461 {
    public int numSub(String s) {
        int[] dp = new int[s.length()+1];
        char[] array = s.toCharArray();
        int mod = (int) (1e7 + 9);
        for (int i = 0; i < s.length() ; i++) {
           if (array[i] == '1'){
               dp[i+1] = dp[i] + 1;
               dp[i+1] %= mod;
           }
           else {
               dp[i+1] = 0;
           }
        }
        int count = 0;
        for (int i = 1; i < dp.length ; i++) {
            count += dp[i];
            count %= mod;
        }
        return count;
    }
}
