package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/29 23:01
 * @Description:
 */
public class LeetCode_14_1 {
    public static void main(String[] args) {
        System.out.println(Math.pow(3,4) + " " + pow(3,4));
    }
    public int cuttingRope(int n) {
        long[] dp = new long[n+1];
        int mod = (int) (1e9 + 7);
        dp[1] = 1;
        for (int i = 2; i < dp.length ; i++) {
            for (int j = 1; j < i ; j++) {
                dp[i] = Math.max((i - j) * dp[j], Math.max((i - j) * j,dp[i]));
            }
        }
        return (int) (dp[n] % mod);
    }
    public int cuttingRope1(int n) {
        if (n <= 3){
            return n - 1;
        }
        int mod = (int)1e9 + 7;
        int b = n % 3;
        long rem = 1, x = 3;
        // a是3的幂
        for (int a = (n / 3) -1; a > 0 ; a /= 2) {
            if ((a & 1) == 1){
                rem = (rem * x) % mod;
            }
            x = (x * x) % mod;
        }
        // 当 b=0 时 直接返回 rem * 3 % mod
        if (b == 0){
            return (int)(rem * 3 % mod);
        }
        // 当 b=1 时，要将一个1+3 转换为 2+2
        if (b == 1){
            return (int)(rem * 4 % mod);
        }

        return (int)(rem * 6 % mod);
    }

    public static int pow(int n, int pow){
        int base= n;
        int res = 1;
        for (int i = pow; i > 0; i /= 2) {
            if ((i & 1) == 1){
                res *= base;
            }
            base *= base;
        }
        return res;
    }

}
