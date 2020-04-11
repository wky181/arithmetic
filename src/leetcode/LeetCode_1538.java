package leetcode;

import bluebridgecup_course.class_03.Util;
import sun.misc.Queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/3/20 23:02
 * @Description: [0, 0, 1, 2, 4, 2, 2, 3, 1, 4]
 * 8
 */
public class LeetCode_1538 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        sort(nums, 8);
    }

    //快排来做
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        if (k < 0 || k > arr.length) {
            return null;
        }
        sort(0, arr.length - 1, arr, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        Util.print(res);
        return res;
    }

    public static void sort(int l, int r, int[] nums, int k) {
        if (l < r) {
            int partation = partation(l, r, nums);
            if (partation + 1 < k) {
                sort(partation + 1, r, nums, k);
            } else {
                sort(l, partation - 1, nums, k);
            }
        }
    }

    public static int partation(int l, int r, int[] nums) {
        int mark = l;
        int p = nums[l];
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < p) {
                mark++;
                swap(mark, i, nums);
            }
        }
        swap(mark, l, nums);
        return mark;
    }

    public static void swap(int i, int j, int[] nums) {
        if (nums[i] != nums[j]) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    //堆排来做
    public static void sort(int[] num , int k) {
        buildMaxHeap(num,k);
        for (int i = k; i < num.length ; i++) {
            if (num[i] < num[0]){
                swap(i,0,num);
                heapDown(0,num,k);
            }
        }
        int[] res = new int[k];
        System.arraycopy(num,0,res,0,k);
        Util.print(res);
    }

    public static void buildMaxHeap(int[] num , int k) {
        int index = (k / 2) + 1;
        for (int i = index; i >= 0; i--) {
            heapDown(i,num,k);
        }
    }

    public static void heapDown(int i, int[] num, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int maxIndex = i;
        if (right < length && num[right] > num[maxIndex]){
            maxIndex = right;
        }
        if (left < length && num[left] > num[maxIndex]){
            maxIndex = left;
        }
        if (maxIndex != i){
            swap(maxIndex,i,num);
            heapDown(maxIndex,num,length);
        }
    }
    //利用PriorityQueue来实现堆排序
    // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
    // 1. 若目前堆的大小小于K，将当前数字放入堆中。
    // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
    //    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
    public int[] getLeastNumbers1(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((v1,v2) -> v2 - v1);
        for (int i = 0; i < arr.length ; i++) {
            if (heap.size() <= k){
                heap.offer(arr[i]);
            }else if (heap.peek() > arr[i]){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        int index = 0;
        for (Integer integer: heap) {
            res[index++] = integer;
        }
        return res;
    }
}
