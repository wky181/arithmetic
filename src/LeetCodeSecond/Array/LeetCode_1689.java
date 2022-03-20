package LeetCodeSecond.Array;

/**
 * @Author: wky233
 * @Date: 2020/7/31 20:44
 * @Description:
 */
public class LeetCode_1689 {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] == 0){
            return 0;
        }
        int res = -1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > mid){
                right = mid-1;
                if (nums[mid] == mid){
                    res = mid;
                }
            }else {
                left = mid;
            }
        }
        return res;
    }
}
