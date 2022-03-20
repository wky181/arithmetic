package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/1 0:42
 * @Description: 两次单调栈遍历确定无序数组的左右边界
 */
public class LeetCode_581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length - 1;
        int rigth = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        // 找左边界
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] < nums[deque.peekLast()]) {
                left = Math.min(left, deque.pollLast());
            }
            deque.addLast(i);
        }
        deque.clear();
        // 找右边界
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                rigth = Math.max(rigth, deque.pollLast());
            }

            deque.addLast(i);
        }
        return rigth - left > 0 ? rigth - left + 1 : 0;
    }
}
