package LeetCodeSecond.weekrank;

import java.util.Arrays;

/**
 * @Author: wky233
 * @Date: 2020/6/29 21:24
 * @Description:
 */
public class LeetCode_1498 {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = (int) (1e9 + 7);
        int res = 0;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < pow.length ; i++) {
            pow[i] = pow[i-1] * 2;
            pow[i] = pow[i] % mod;
        }
        for (int i = 0, j = nums.length-1; i < nums.length ; i++) {
            while (j >= i && nums[i] + nums[j] > target){
                j--;
            }
            if (i > j){
                break;
            }
            // 以i为首在 i到j的序列中有 2^n-1 个
            res += pow[j-i];
            res %= mod;
        }
        return res;
    }
}
