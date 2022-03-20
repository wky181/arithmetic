package LeetCodeSecond.sort;

/**
 * @Author: wky233
 * @Date: 2020/6/29 16:40
 * @Description:
 */
public class LeetCode_215 {
    public int findKthLargest(int[] nums, int k) {
        int targetIndex = nums.length - k;
        return sortFind(nums,0,nums.length-1,targetIndex);

    }
    public int sortFind(int[] nums, int left, int right, int targetIndex){
        if (left >= right){
            return -1;
        }
        int povit = povit(nums,left,right);
        if (povit == targetIndex){
            return nums[povit];
        }
        else if (povit < targetIndex){
            return sortFind(nums,povit+1,right,targetIndex);
        }else {
            return sortFind(nums,left,povit-1,targetIndex);
        }

    }
    public int povit(int[] nums, int left, int right){
        int p = nums[left];
        int mark = left;
        for (int i = left+1; i <= right ; i++) {
            if (nums[i] < p){
                mark++;
                swap(i,mark,nums);
            }
        }
        swap(left,mark,nums);
        return mark;
    }
    public void swap(int i, int j, int[] nums){
        if (nums[i] == nums[j]){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
