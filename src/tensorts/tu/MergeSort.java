package tensorts.tu;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/3/9 16:54
 * @Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        System.out.println(randomArr.length);
        new tensorts.tu.MergeSort().sort(randomArr, 0, randomArr.length - 1);
        Util.print(randomArr);
    }
    public void sort(int[] nums , int l , int r){
        if (l < r){
            int mid = l + ((r - l)>>1);
            sort(nums,l,mid);
            sort(nums,mid+1,r);
            mergeSort(nums,l,mid,r);
        }
    }
    public void mergeSort(int[] nums, int l , int mid, int r){
        int[] helper = new int[nums.length];
        System.arraycopy(nums,l,helper,l,r-l+1);
        int left = l;
        int right = mid+1;
        int current = l;
        while (left <= mid && right <= r){
            if (helper[left] < helper[right]){
                nums[current++] = helper[left++];
            }else {
                nums[current++] = helper[right++];
            }
        }
        while (left <= mid ){
            nums[current++] = helper[left++];
        }
    }
}
