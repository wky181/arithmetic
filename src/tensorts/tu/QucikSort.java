package tensorts.tu;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/3/9 16:30
 * @Description:
 */
public class QucikSort {
    public static void main(String[] args) {
        int[] nums = Util.getRandomArr(10,1,100);
        Util.print(nums);
        new QucikSort().sort(nums,0,nums.length-1);
        Util.print(nums);
    }
    public void sort(int[] nums,int l , int r){
        if (l < r){
            int p = partition(nums,l,r);
            sort(nums,l,p-1);
            sort(nums,p+1,r);
        }
    }
    public int partition(int[] nums,int l , int r){
        //代表左边序列的最右边下标
        int mark = l;
        int pavoit = nums[l];
        for (int i = l+1; i <= r ; i++) {
            if (nums[i] < pavoit){
                mark++;
                swap(nums,mark,i);
            }
        }
        swap(nums,mark,l);
        return mark;
    }
    public void swap(int[] nums , int i, int j){
        if (nums[i] == nums[j]){
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
