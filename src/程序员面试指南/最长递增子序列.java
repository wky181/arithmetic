package 程序员面试指南;

/**
 * @author 武凯焱
 * @date 2019/3/21 19:59
 * @Description:
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] arr = {2,1,5,3,6,4,8,9,7};
        solve(arr);
    }
    public static void solve(int[] arr){
        int[] dp = new int[arr.length];
        for (int i = 0; i <dp.length ; i++) {
            dp[i] = 1;
            for (int j = 0; j <i ; j++) {
                if (arr[i]>arr[j]){
                    dp[i] = Math.max(1+dp[j],dp[i]);
                }
            }

        }
        int len = 0;
        int index = 0;
        for (int i = 0; i <dp.length ; i++) {
            if (dp[i]>len){
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
        res[len-1] = arr[index];
        for (int i = index-1; i >=0 ; i--) {
            if (arr[index] >arr[i] && dp[i]+1 == dp[index]){
                res[--len-1] = arr[i];
                index=i;
            }
        }
        for (int i = 0; i < res.length; i++) {
           System.out.print(res[i]+" ");
        }
    }
}
