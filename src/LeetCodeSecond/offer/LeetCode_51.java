package LeetCodeSecond.offer;

/**
 * @Author: wky233
 * @Date: 2020/7/12 9:19
 * @Description:
 */
public class LeetCode_51 {
    private int nixu;
    private int[] temp;
    public int reversePairs(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        temp = new int[nums.length];
        merge(nums,0,nums.length-1,temp);
        return nixu;
    }

    public void merge(int[] nums, int left, int right, int[] temp){
        if (left == right){
            return;
        }
        int mid = left + (right - left) / 2;
        merge(nums,left,mid,temp);
        merge(nums,mid+1,right,temp);
        if (nums[mid+1] >= nums[mid]){
            return;
        }
        mergeFind(nums,left,mid,right,temp);
    }

    private void mergeFind(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }
        int l = left;
        int r = mid+1;
        for (int i = left; i <= right ; i++) {
            if (l > mid){
                nums[i] = temp[r++];
            }
            else if (r > right){
                nums[i] = temp[l++];
                nixu += right - mid;
            }else if (temp[l] <= temp[r]){
                nums[i] = temp[l++];
                nixu += r - mid - 1;
            }else {
                nums[i] = temp[r++];
            }

        }
    }
}
