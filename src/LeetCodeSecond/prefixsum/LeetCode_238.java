package LeetCodeSecond.prefixsum;

/**
 * @Author: wky233
 * @Date: 2020/6/4 21:48
 * @Description: 前后乘积缀
 */
public class LeetCode_238 {
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums) {
        int[] preSum = new int[nums.length+1];
        int[] endSum = new int[nums.length+1];
        preSum[0] = 1;
        for (int i = 1; i < preSum.length ; i++) {
            preSum[i] = preSum[i-1] * nums[i-1];
        }
        endSum[nums.length] = 1;
        for (int i = endSum.length-2; i >= 0 ; i--) {
            endSum[i] = nums[i] * endSum[i+1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            res[i] = preSum[i] * endSum[i+1];
        }
        return res;
    }
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length ; i++) {
            res[i] = k;
            //下一个i的左边前缀积
            k *= nums[i];
        }
        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // res[i] = 左边前缀积*右边前缀积
            res[i] *= k;
            //下一个i的右边前缀积
            k *= nums[i];
        }
        return res;
    }
}
