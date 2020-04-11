package leetcode;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/3/25 15:13
 * @Description:
 */
public class LeetCode_416 {
    public static void main(String[] args) {
        int[] nums = {1,2,5};
        System.out.println(new LeetCode_416().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        if (res % 2 != 0) {
            return false;
        }
        int capticy = res / 2;
        //tryPartition()
        int[][] memo = new int[nums.length][capticy+1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-1);
        }
       return tryPartition(nums,capticy,nums.length-1,memo);
    }

    public boolean tryPartition(int[] nums, int capity, int index,int[][] memo) {
        if (index < 0 || capity < 0) {
            return false;
        }
        if (capity == 0) {
            return true;
        }
        if (memo[index][capity] != -1){
            return memo[index][capity] == 1;
        }
        boolean is = tryPartition(nums, capity, index - 1,memo) || tryPartition(nums, capity - nums[index], index-1,memo);
        if (is){
            memo[index][capity] = 1;
        }else {
            memo[index][capity] = 0;
        }
        return is;
    }
    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
        }
        if (res % 2 != 0) {
            return false;
        }
        int capticy = res / 2;
        //tryPartition()
        boolean[] memo = new boolean[capticy+1];
        for (int i = 0; i <= capticy ; i++) {
            memo[i] = nums[0] == capticy;
        }
        for (int i = 1; i < nums.length ; i++) {
            for (int j = capticy; j >= nums[i] ; j--) {
                memo[j] = memo[j] || memo[j-nums[i]];
            }
        }
        return memo[capticy];
    }
}
