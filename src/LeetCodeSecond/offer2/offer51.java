package LeetCodeSecond.offer2;

/**
 * @Author: wky233
 * @Date: 2020/9/16 21:40
 * @Description:
 */
public class offer51 {
    int xinu = 0;
    public int reversePairs(int[] nums) {
        sort(nums,0, nums.length - 1, new int[nums.length]);
        return xinu;
    }
    public void sort(int[] nums, int left, int right, int[] temp){
        if (left < right){
            int mid = left + (right - left) / 2;
            sort(nums, left, mid, temp);
            sort(nums,mid + 1, right, temp);
            if (nums[mid + 1] >= nums[mid]){
                return;
            }
            merge(nums, left, mid, right, temp);
         }
    }
    public void merge(int[] nums, int left, int mid, int right, int[] temp){
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }
        int l = left;
        int r = mid + 1;
        for (int i = left; i <= right ; i++) {
            if (l > mid){
                nums[i] = temp[r++];
            }else if (r > right){
                nums[i] = temp[l++];
            }else if (temp[l] > temp[r]){
                nums[i] = temp[r++];
                xinu += (mid - l + 1);
            }else {
                nums[i] = temp[l++];
            }
        }
    }
}
