package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/9 10:21
 * @Description:
 */
public class LeetCodemian_42 {
    public static void main(String[] args) {

    }
    // 使用贪心算法来解这道题
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int sum = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length ; i++) {
            // 如果当前的连续数组和是小于0的那么直接从头开始，因为如果还按照原来找就不是最大和了
            if (sum < 0){
                sum = nums[i];
        }else {
                sum += nums[i];
            }
            res = Math.max(sum,res);
        }
        return res;
    }
}
