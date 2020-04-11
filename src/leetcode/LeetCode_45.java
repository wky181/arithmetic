package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/31 14:02
 * @Description:
 */
public class LeetCode_45 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int jump = new LeetCode_45().jump(nums);
        System.out.println(jump);
    }
    int[] dp ;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,nums.length);
        return slove(nums,0);
    }
    // 使用动态规划发现超时
    public int slove(int[] nums, int index) {
        if (index >= nums.length -1) {
            return 0;
        }
        if (dp[index] != nums.length){
            return dp[index];
        }
        int steps = nums[index];
        int min = nums.length;
        for (int i = 1; i <= steps; i++) {
           min =  Math.min(min, slove(nums, index + i) +1);
        }
        dp[index] = min;
        return min;
    }
    //使用贪心算法来解
    public int jump1(int[] nums) {
        // 每次起跳点的结束点
        int end = 0;
        // 最远的长度
        int fastpath = 0;
        // 跳跃次数
        int jump =0;
        // nums.length -1 是到达最后一个点了，不需要再计算了。
        for (int i = 0; i < nums.length-1 ; i++) {
            fastpath = Math.max(fastpath,i+nums[i]);
            //起跳点和结束点相同，开始起跳,调到最远的长度。
            if (i == end){
                end = fastpath;
                jump++;
            }
        }
        return jump;
    }
}
