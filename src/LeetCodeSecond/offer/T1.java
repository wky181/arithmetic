package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/8/16 16:36
 * @Description:
 */
public class T1 {
    int[] dp;
    public int count(int money){
        dp = new int[money+1];
        dfs(money);
        return dp[money];
    }
    public  int dfs(int n){
        if (n == 0){
            return 0;
        }else if (dp[n] != 0){
            return dp[n];
        }
        int res = 0;
        for (int i = 1; i < n ; i++) {
            res += dfs(n - i);
        }
        dp[n] = res +1;
        return res+1;
    }

    public static void main(String[] args) {
        int count = new T1().count(12);
        System.out.println(Math.pow(2,11));
        System.out.println(count);
    }
}
