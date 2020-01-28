package leetcode;

import bluebridgecup_course.class_03.Util;

import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/1/24 21:35
 * @Description:
 */
public class LeetCode_215 {
    public static void main(String[] args) {
        int[] nums = {9, 10, 3, 10, 9, 3, 8, 1, 2, 10, 1, 5, 4, 9, 8, 1, 3, 10, 1, 9};
        Util.print(nums);
       int k =  new LeetCode_215().findKthLargest1(nums,4);
        System.out.println(k);
    }
    public int findKthLargest(int[] nums, int k) {
        return findK(nums,0,nums.length-1,k);

    }
    public int findK(int[] nums, int first,int end,int value){
        if (first <= end) {
            int p = pavion(nums, first, end);
            System.out.println(p);
            if (p == (value - 1)) {
                return nums[p];
            } else if (p < (value - 1)) {
              return findK(nums, p + 1, end, value);
            } else {
              return findK(nums, first, p - 1, value);
            }
        }
        return 0;
    }
    public int pavion(int[] nums,int first,int end){
        //优化选取合理的pivot
        int mid = (first+end)/2;
        int midValueIndex = -1;
        if (nums[first] <= nums[mid] && nums[end] >= nums[mid]){
            midValueIndex  = mid;
        }else if (nums[first] >= nums[mid] && nums[first] <= nums[end]){
            midValueIndex  = first;
        }else {
            midValueIndex  = end;
        }
        Util.swap(nums,first,midValueIndex);
        int p = first;
        int l = first+1;
        int r = end;
        while (l <= r){
            if (nums[l] > nums[p]){
                l++;
            }else {
                Util.swap(nums,l,r--);
            }
        }
        Util.swap(nums,p,r);
        return r;
    }

    /**
     * 采用PriorityQueue实现大小顶堆 解决topK问题
     */
    public int findKthLargest1(int[] nums, int k) {
        //队列默认自然顺序排列，小顶堆，不必重写compare
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int number: nums ) {
            if (pq.size() < k){
                pq.offer(number);
            }else if (number > pq.peek()){
                //移除小根堆堆顶元素，维持当前最大k个值
                pq.poll();
                pq.offer(number);
            }
        }
        return pq.poll();
    }


}
