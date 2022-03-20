package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/6/30 9:32
 * @Description:
 */
public class LeetCode_53_1 {
    public static void main(String[] args) {
        Integer integer = 100;
        Integer integer1 = 100;
        System.out.println(integer == integer1);
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        // 先求左边界
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                // 收缩右边界
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target){
            return 0;
        }
        int l = left;
        left = 0;
        right = nums.length-1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                // 收缩左边界
                left = mid + 1;
            }
        }
        if (left == 0 || nums[left - 1] != target ){
            return 0;
        }
        int r = left;
        return  r - l + 1;
    }

    public int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        // 先求左边界
        while (left < right){
            int mid = left + (right - left) / 2;
            // 如果左边区间不满足则去掉
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        if (nums[left] != target){
            return 0;
        }
        int l = left;
        left = 0;
        right = nums.length-1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            // 如果右边不满足条件去掉
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid;
            }
        }
        if (nums[left] != target ){
            return 0;
        }
        int r = left;
        return  r - l + 1;
    }
}
