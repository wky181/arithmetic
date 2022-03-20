package LeetCodeSecond.offer;

import sun.java2d.pipe.AAShapePipe;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/6/30 23:06
 * @Description: 单调队列 单调递减的队列 + 滑动窗口
 */
public class LeetCode_59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[]{};
        }
        Deque<Integer>  deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            if (i >= k-1){
                res[index++] = deque.peek();
                int last = nums[i-k+1];
                if (last == deque.peek()){
                    deque.poll();
                }
            }
        }
        return res;
    }
}
