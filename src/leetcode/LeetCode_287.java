package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/23 23:52
 * @Description:
 */
public class LeetCode_287 {
    public int findDuplicate(int[] nums) {
        int right = nums.length - 1;
        int left = 1;
        // 解本道题的关键就是 先求出中间数mid
        // 然后遍历整个数组统计小于mid的数字个数，如果大于等于 mid，说明重复数在left ~ mid -1闭区间中
        // 否则再 mid ~ right
        while (left < right){
            int mid = (left + right + 1 ) >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num < mid){
                    count++;
                }
            }
            if (count >= mid ){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        return left;
    }
    // 二分法来做
    public int findDuplicate1(int[] nums) {
        int right = nums.length - 1;
        int left = 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            int count = 0;
            for (int i = 0; i < nums.length ; i++) {
                if (nums[i] < mid){
                    count++;
                }
            }
            if (count >= mid){
                right = mid -1;
            }else {
                left = mid;
            }
        }
        return left;
    }
    // 快慢指针来做
    public int findDuplicate2(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        int start = 0;
        int cur = fast;
        while (start != cur){
            start = nums[start];
            cur = nums[cur];
        }
        return cur;
    }
}
