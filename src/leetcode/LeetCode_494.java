package leetcode;

import java.util.Arrays;

/**
 * @author 武凯焱
 * @date 2019/10/26 16:08
 * @Description: 目标和
 */
public class LeetCode_494 {
    static int sum;

    public static void main(String[] args) {
        int[] nums = {
                1, 1, 1, 1, 1
        };
        System.out.println(new LeetCode_494().slove1(nums,3));


    }

    /**
     * 暴力递归
     *
     * @param nums
     * @param s
     * @param temp
     * @param number
     */
    private static void BFS(int[] nums, int s, int temp, int number) {
        if (number == nums.length) {
            sum = temp == s ? ++sum : sum;
        } else {
            BFS(nums, s, temp + nums[number], number + 1);
            BFS(nums, s, temp - nums[number], number + 1);
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][S + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        slove(nums, 0, S, memo);
        return memo[0][S];
    }

    public int slove(int[] nums, int index, int target, int[][] memo) {
        if (target < 0 || index > nums.length) {
            return 0;
        }
        if (index == nums.length && target == 0) {
            return 1;
        }
        if (memo[index][target] != -1) {
            return memo[index][target];
        }
        int res = 0;
        res += slove(nums, index + 1, target - nums[index], memo);
        res += slove(nums, index + 1, target + nums[index], memo);
        memo[index][target] = res;
        return res;
    }

    //自底向上,类似背包问题
    public int slove(int[] nums, int S) {
        if (S > 1000) {
            return -1;
        }
        int[][] memo = new int[nums.length][2001];
        memo[0][1000 + nums[0]] = 1;
        memo[0][1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (memo[i - 1][j + 1000] > 0) {
                    memo[i][j + nums[i] +1000] += memo[i - 1][j + 1000];
                    memo[i][j - nums[i] +1000] += memo[i - 1][j + 1000];
                }
            }
        }
        return memo[nums.length-1][S+1000];
    }
    //压缩空间
    public int slove1(int[] nums, int S) {
        int[][] dp = new int[2][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[(i - 1) % 2][sum + 1000] > 0) {
                    dp[i % 2][sum + nums[i] + 1000] += dp[(i - 1) % 2][sum + 1000];
                    dp[i % 2][sum - nums[i] + 1000] += dp[(i - 1) % 2][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[(nums.length-1)%2][S + 1000];
    }
}
