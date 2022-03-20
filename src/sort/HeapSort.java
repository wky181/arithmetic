package sort;

import bluebridgecup_course.class_03.Util;

/**
 * @Author: wky233
 * @Date: 2020/8/14 21:35
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] randomArr = Util.getRandomArr(10, 1, 60);
        Util.print(randomArr);
        new HeapSort().sort(randomArr);
        Util.print(randomArr);
    }
    public void sort(int[] nums){
        int len = nums.length;
        buildMaxHeap(nums);
        for (int i = 0; i < nums.length-1 ; i++) {
            swap(nums,0, len-1);
            len--;
            maxHeapDown(0, len, nums);
        }
    }

//    private void buildMaxHeap(int[] nums) {
//        int last = nums.length / 2 - 1;
//        for (int i = last; i >= 0 ; i--) {
//            maxHeapDown(i,nums.length,nums);
//        }
//    }
    public void buildMaxHeap(int[] nums){
        int last = (nums.length - 1) / 2;
        for (int i = last; i >= 0; i--) {
            maxHeapDown(i,nums.length, nums);
        }
    }
    private void maxHeapDown(int i, int len, int[] nums) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max = i;
        if (left < len && nums[left] > nums[max]){
            max = left;
        }
        if (right < len && nums[right] > nums[max]){
            max = right;
        }
        if (max != i) {
            swap(nums, max, i);
            maxHeapDown(max,len,nums);
        }
     }

    private void swap(int[] nums, int a, int b) {
        if (nums[a] == nums[b]){
            return;
        }
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }

}
