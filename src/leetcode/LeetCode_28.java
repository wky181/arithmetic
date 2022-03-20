package leetcode;

import java.util.HashSet;

/**
 * @Author: wky233
 * @Date: 2020/4/23 15:53
 * @Description:
 */
public class LeetCode_28 {
    public static void main(String[] args) {
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.length() > haystack.length()){
            return -1;
        }
        KMP kmp = new KMP(needle);
        int search = kmp.search(haystack);
        return search;
    }

    private class KMP {
        private int[][] dp;
        private String pat;

        public KMP(String pat) {
            int M = pat.length();
            this.dp = new int[M][256];
            this.pat = pat;
            char[] array = pat.toCharArray();
            //定义base case i 状态比 X状态先行一步
            dp[0][array[0]] = 1;
            //影子X 记录当前i位置前面的具有相同前缀的状态
            int X = 0;
            for (int i = 1; i < M; i++) {
                for (int j = 0; j < 256 ; j++) {
                    // 如果与当前要匹配的array[i]不同，就要找X状态重构状态
                    dp[i][j] = dp[X][j];
                    // 如果与当前要匹配的array[i]相同，就进入下一个状态。
                    dp[i][array[i]] = i +1 ;
                }
                // 更新影子状态
                X = dp[X][array[i]];
            }
        }
        public int search(String txt){
            int M = pat.length();
            int N = txt.length();
            int index = 0;
            for (int i = 0; i < N ; i++) {
                   index = dp[index][txt.charAt(i)];
                    // 说明pat已经到了终止状态，返回起始匹配位置
                    if (index == M){
                        return i - M + 1;
                    }
            }
            //没有匹配到
            return -1;
        }
    }
}
