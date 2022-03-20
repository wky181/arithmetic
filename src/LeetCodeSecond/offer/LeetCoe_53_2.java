package LeetCodeSecond.offer;
/**
 * @Author: wky233
 * @Date: 2020/6/30 12:42
 * @Description:
 */
public class LeetCoe_53_2 {
    // 有序 二分
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            // 找最左边下标与值不匹配的元素
            if (mid == nums[mid]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if (nums[left] == left){
            return left + 1;
        }
        return left;
    }
}
