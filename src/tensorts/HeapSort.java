package tensorts;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/3/9 0:16
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        new HeapSort().sort(randomArr);
        Util.print(randomArr);
    }
    public void sort(int[] nums){
       maxHeap(nums);
       int len = nums.length;
        for (int i = 0; i < nums.length-1 ; i++) {
            swap(nums,0,len-1);
            len -= 1;
            maxHeapDown(nums, 0, len);
        }
    }
    public void maxHeap(int[] nums){
        int last = nums.length / 2 -1;
        for (int i = last; i >= 0 ; i--) {
            maxHeapDown(nums,i,nums.length-1);
        }

    }
    public void maxHeapDown(int[] nums,int i,int len){
        int left = i * 2 +1;
        int right = i * 2 +2;
        int max = i;
        if (left < len && nums[left] > nums[max] ){
            max = left;
        }
        if (right < len && nums[right] > nums[max]){
            max = right;
        }
        if (max != i){
            swap(nums,i,max);
            maxHeapDown(nums,max,len);
        }
    }
    public void swap(int[] nums , int i , int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[j] ^ nums[i];

    }
}
