package tensorts;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/4/24 21:37
 * @Description:
 */
public class MergeSortPlus {
    public static void main(String[] args) {
        int[] arr = Util.getRandomArr(10, 1, 10);
        Util.print(arr);
        new MergeSortPlus().mergeSort(arr);
        Util.print(arr);
    }
    public void mergeSort(int[] nums){
        if (nums.length < 2){
            return;
        }
        // 只创建一次辅助数组，避免来回创建数组
        int[] temp = new int[nums.length];
        sort(nums,0,nums.length-1,temp);
    }
    /**
     *
     * @param nums
     * @param left
     * @param right l和r 左闭右闭
     * @param temp 辅助空间数组
     */
    public void sort(int[] nums, int left, int right, int[] temp){
        // 这里left和right相等，数组只有一个元素直接返回不必排序
        if (left == right){
            return;
        }
        // 这里是向下取整了所以左区间边界是 left mid 右边界为 mid+1 right
        int mid = left + (right - left) / 2;
        //对左右区间进行一个排序
        sort(nums,left,mid,temp);
        sort(nums,mid+1, right,temp);
        // 如果左右两个区间连起来本身就有序就不必再合并
        if (nums[mid] > nums[mid+1]){
            Merge(nums,left,mid,right,temp);
        }

    }
    public void Merge(int[] nums, int left,int mid, int right, int[] temp){
        // 先对辅助区间从left到right的赋值，后面要用到
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }
        int l = left;
        int r = mid+1;
        for (int i = left; i <= right ; i++) {
            if (l == mid+1){
                nums[i] = temp[r];
                r++;
            }
            else if (r == right+1){
                nums[i] = temp[l];
                l++;
            }
            else if (temp[l] <= temp[r]){
                nums[i] = temp[l];
                l++;
            }else {
                nums[i] = temp[r];
                r++;
            }
        }
    }
}
