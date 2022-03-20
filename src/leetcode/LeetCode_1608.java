package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/28 14:59
 * @Description:
 */
public class LeetCode_1608 {
    public int[] singleNumbers(int[] nums) {
        // 分组A
        int a = 0;
        // 分组B
        int b = 0;
        // 所有值异或后的结果
        int ans = 0;
        for (int i = 0; i < nums.length ; i++) {
            ans ^= nums[i];
        }
        // ans至少有一位为1 并且为1代表着不相同的数字在该位上要么为0要么为1
        // 那么我们就可以依据该位对数组进行分组
        // 1.相同的数字分为1组，并且不同的数字要分在两个组中，如果两个数字相同，那么与该位与后的结果也相同
        int n = 1;
        // 找到ans位为1对应的n
        while ((ans & n) == 0){
            n = n << 1;
        }
        for (int num: nums) {
            if ((num & n) == n){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[] {a, b};
    }
}
