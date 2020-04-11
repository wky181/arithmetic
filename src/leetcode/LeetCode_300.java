package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/25 14:19
 * @Description:
 */
public class LeetCode_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lis = new int[nums.length];
        lis[0] = 1;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j]);
                }
            }
            lis[i] += 1;
            res = Math.max(res,lis[i]);
        }
        return res;
    }
}
