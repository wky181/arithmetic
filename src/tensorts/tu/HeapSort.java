package tensorts.tu;

import bluebridgecup_course.class_03.Util;
import tensorts.QuickSort;

/**
 * @Author: wky233
 * @Date: 2020/3/9 14:25
 * @Description:
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = Util.getRandomArr(1000,1,1000);
        Util.print(nums);
        int n = new HeapSort().topN(nums, 20);
        System.out.println(n);
        new  QuickSort().sort(nums,0,nums.length);
        Util.print(nums);
        System.out.println(nums[980]);
    }
    public int topN(int[] nums ,int n){
       minHeap(nums,n);
        for (int i = n; i < nums.length ; i++) {
            if (nums[i] > nums[0] ){
                swap(nums,i,0);
                minHeapDown(nums,0,n);
            }
        }
        return nums[0];
    }
    public void minHeap(int[] nums , int n){
        int num = n /2 -1;
        for (int i = num; i >= 0 ; i--) {
            minHeapDown(nums,i,n);
        }
    }
    public void minHeapDown(int[] nums ,int i, int n){
        int left = 2 * i +1;
        int right = 2 * i + 2;
        int min = i;
        if (left < n && nums[left] < nums[min]){
            min = left;
        }
        if (right < n && nums[right] < nums[min]){
            min = right;
        }
        if (i != min){
            swap(nums,min,i);
            minHeapDown(nums,min,n);
        }
    }
    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[j] ^ nums[i];
    }
}
