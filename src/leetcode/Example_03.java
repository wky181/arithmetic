package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/25 13:06
 * @Description:
 */
public class Example_03 {
    public static void main(String[] args) {
        int[] w = {5, 4, 7, 2, 6};
        int[] v = {12, 3, 10, 3, 6};
        int[] nums = {2,4,1,5,3};
        int res = dp1(w, v, nums,15);
        System.out.println(res);
    }
    //优化 压缩空间到一位数组O(c)
    public static int dp1(int[] w, int[] v, int[] num, int c) {
        int[] memo = new int[c + 1];
        for (int i = 1; i <= c; i++) {
            if (i - w[0] >= 0 && i/w[0] <= num[0]) {
                int k = i / w[0];
                memo[i] = v[0] * k;
            }else {
                memo[i] = memo[i-1];
            }
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= c; j++) {
                //当前w[i] 判断是否有空间放的下
                if (j - w[i] >= 0 && memo[j-w[i]]/w[i] <= num[i]-1 ) {
                    //0 0 3 3 6 12 12 15 15 18 24 24 27 27 30 36
                    //只需要考虑当前w[i]要不要取，不取就是memo[j] 取了就是memo[j-w[i]] + v[i]
                    // 因为memo[j-w[i]]已经考虑过了memo[j-w[i]] 与 取 0 到 k = j-w[i]/w[i] 个 w[i]的最大值
                    // 所以只需要考虑本层c从1开始, 取w[i]与不取  取了就是memo[j-w[i]] + v[i], j-w[i]表示上一个取了的最大值
                    memo[j] = Math.max(memo[j], memo[j-w[i]] + v[i]);
                }else if (j - w[i] >= 0){
                    memo[j] = Math.max(memo[j], memo[j-w[i]] );
                }
            }
            for (int j = 0; j <= c; j++) {
                System.out.print(memo[j] + " ");
            }
            System.out.println();
        }
        return memo[c];
    }
}
