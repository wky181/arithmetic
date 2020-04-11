package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/30 14:44
 * @Description:
 */
public class LeetCode_376 {
    public static void main(String[] args) {

    }

    public int wiggleMaxLength(int[] nums) {
        int status = 0;
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (status == 0) {
                if (nums[i] > nums[i-1]){
                    status = 2;
                    dp[i] += dp[0];
                }else if (nums[i] < nums[i-1]){
                    status = 1;
                    dp[i] += dp[0];
                }
            }else if (status == 1 && nums[i] > nums[i-1]){
                dp[i] += dp[i-1];
                status = 2;
            }else if (status == 2 && nums[i] < nums[i-1]){
                dp[i] += dp[i-1];
                status = 1;
            }else {
                status = 0;
            }
            res  = Math.max(dp[i],res);
        }
        return res;
    }
    public int wiggleMaxLength1(int[] nums) {
        if (nums.length <= 2){
            return nums.length;
        }
        int[][] memo = new int[nums.length][2];
        for (int i = 0; i < memo.length ; i++) {
            Arrays.fill(memo[i],1);
        }
        for (int i = 1; i < nums.length ; i++) {
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]){
                    memo[i][1] = Math.max(memo[i][1],memo[j][0]+1);
                }else if (nums[i] < nums[j]){
                    memo[i][0] = Math.max(memo[i][0],memo[j][1]+1);
                }
            }
        }
        return Math.max(memo[nums.length-1][0],memo[nums.length-1][1]);
    }
    public int wiggleMaxLength2(int[] nums) {
        if (nums.length <= 2){
            return nums.length;
        }
        int[][] memo = new int[nums.length][2];
        for (int i = 0; i < memo.length ; i++) {
            Arrays.fill(memo[i],1);
        }
        for (int i = 1; i < nums.length ; i++) {
                if (nums[i] > nums[i-1]){
                    memo[i][1] = memo[i-1][0]+1;
                    memo[i][0] = memo[i-1][0];
                }else if (nums[i] < nums[i-1]){
                    memo[i][0] = memo[i-1][1]+1;
                    memo[i][1] = memo[i-1][1];
                }else {
                    memo[i][0] = memo[i-1][0];
                    memo[i][1] = memo[i-1][1];
                }
        }
        return Math.max(memo[nums.length-1][0],memo[nums.length-1][1]);
    }
    public int wiggleMaxLength3(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] > nums[i-1]){
                up = down+1;
            }else if (nums[i] < nums[i-1]){
                down = up+1;
            }
        }
        return Math.max(down,up);
    }
}
