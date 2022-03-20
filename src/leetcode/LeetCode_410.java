package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/1 12:44
 * @Description: 二分法
 */
public class LeetCode_410 {
    public int splitArray(int[] nums, int m) {
        int left = nums[0];
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        // 利用二分法来找这个最大值
        while (left < right){
            int mid = (left + right) >>> 1;
            int temp = 0;
            //循环中最后一个数组统计不上，初始值为1
            int count = 1;
            // 统计以mid为最大值时，需要分为几个组
            for (int num: nums) {
                temp += num;
                if (temp > mid){
                    temp = num;
                    count++;
                }
            }
            // 说明分组太多了，需要增大mid的值
            if (count > m){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
