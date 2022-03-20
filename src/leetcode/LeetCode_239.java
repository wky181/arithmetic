package leetcode;

import bluebridgecup_course.class_03.Util;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/4/15 14:36
 * @Description:
 */
public class LeetCode_239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = new LeetCode_239().maxSlidingWindow(nums, k);
        Util.print(ints);

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] resArray = new int[nums.length - k + 1];
        int count = 0;
        MonotonouQueue queue = new MonotonouQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k-1 ) {
                queue.push(nums[i]);
            } else {
                queue.push(nums[i]);
                resArray[count++] = queue.max();
                queue.pop(nums[i - k + 1 ]);
            }
        }
        return resArray;
    }

    private class MonotonouQueue {
        Deque<Integer> queue = new LinkedList<>();

        public void push(Integer n) {
            while (!queue.isEmpty() && queue.peekLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        public void pop(Integer n) {
            if (!queue.isEmpty() && queue.peek().equals(n)) {
                queue.poll();
            }
        }

        public int max() {
            return queue.isEmpty() ? 0 : queue.peek();
        }
    }
}
