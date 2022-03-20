package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/18 22:32
 * @Description:
 */
public class LeetCode_5372 {
    public int minStartValue(int[] nums) {
        int res = 0;
        int min_value = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            min_value = Math.min(res,min_value);
        }
        return min_value >= 0 ? 0 : Math.abs(min_value) + 1;
    }
}
