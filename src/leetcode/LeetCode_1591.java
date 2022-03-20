package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/24 19:59
 * @Description:
 */
public class LeetCode_1591 {
    public int reversePairs(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int[] temp = new int[nums.length];
        int res = sort(nums, 0, nums.length - 1, temp);
        return res;
    }
        public int sort(int[] nums, int left, int right, int[] temp) {
            if (left == right){
                return 0;
            }
            int mid = left + (right - left) / 2;
            int leftNum = sort(nums,left,mid,temp);
            int rightNum = sort(nums,right,mid,temp);
            if (nums[mid] <= nums[mid+1]){
                return leftNum + rightNum;
            }
            int andCount = mergeAndCount(nums, left, mid, right, temp);
            return leftNum + rightNum + andCount;
        }
        public int mergeAndCount(int[] nums, int left,int mid, int right, int[] temp){
            for (int i = left; i <= right ; i++) {
                temp[i] = nums[i];
            }
            int r = mid+1;
            int count = 0;
            for (int i = left; i <= right ; i++) {
                if (left == mid + 1){
                    nums[i] = temp[r];
                    r++;
                }
                else if (r == right + 1){
                    nums[i] = temp[left];
                    left++;
                }
                else if (temp[left] <= temp[r]){
                    nums[i] = temp[left];
                    left++;
                }else {
                    nums[i] = temp[r];
                    r++;
                    count += (mid - left + 1);
                }
            }
            return count;
        }
}
