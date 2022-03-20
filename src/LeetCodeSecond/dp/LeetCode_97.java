package LeetCodeSecond.dp;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/7/18 14:53
 * @Description:
 */
public class LeetCode_97 {
    int m;
    int n;
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] arrayS1 = s1.toCharArray();
        char[] arrayS2 = s2.toCharArray();
        char[] arrayRes = s3.toCharArray();
        dp = new int[arrayS1.length+1][arrayS2.length+1];
        for (int[] nums: dp) {
            Arrays.fill(nums,-1);
        }
        m = 0;
        n = 0;
        if (arrayS1.length + arrayS2.length != s3.length()){
            return false;
        }
        return method(arrayS1,arrayS2,arrayRes,0);
    }

    public boolean method(char[] arrayS1, char[] arrayS2, char[] arrayRes, int index){
        if (index == arrayRes.length){
            return true;
        }
        else if (dp[m][n] != -1){
            return dp[m][n] == 1;
        }
        if (m < arrayS1.length && arrayS1[m] == arrayRes[index]){
            m++;
            if (method(arrayS1,arrayS2,arrayRes,index+1)){
                dp[m][n] = 1;
                return true;
            }
            m--;
        }
        if (n < arrayS2.length && arrayS2[n] == arrayRes[index]){
            n++;
            if (method(arrayS1, arrayS2, arrayRes, index+1)){
                dp[m][n] = 1;
                return true;
            }
            n--;
        }
        dp[m][n] = 0;
        return false;
    }
}
