package LeetCodeSecond.day;

/**
 * @Author: wky233
 * @Date: 2020/6/21 10:32
 * @Description:
 */
public class LeetCode_5440 {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = start + 2 * i;
        }
        long res = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            res ^= nums[i];
        }
        return (int)res;
    }
}
