package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/7/21 16:55
 * @Description:
 */
public class LeetCode_96 {
    int[][] dp;
    public int numTrees(int n) {
        dp = new int[n+1][n+1];
        return find(1,n);
    }

    public int find(int first, int end) {
        if (first > end){
            return 1;
        }else if (dp[first][end] != 0){
            return dp[first][end];
        }
        int count = 0;
        for (int i = first; i <= end ; i++) {
            int left = find(first, i-1);
            int right = find(i+1,end);
            count += left * right;
        }
        dp[first][end] = count;
        return count;
    }
}
