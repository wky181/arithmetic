package LeetCodeSecond.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/5/31 22:02
 * @Description:
 */
public class LeetCode_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> deque = new ArrayDeque<>(nums2.length);
        HashMap<Integer,Integer> hashMap = new HashMap<>(nums2.length);
        for (int i = nums2.length-1; i >=0 ; i--) {
            while (!deque.isEmpty() && nums2[i] > nums2[deque.peekLast()]){
                int curIndex = deque.pollLast();
                hashMap.put(nums2[curIndex], deque.isEmpty() ? -1 : nums2[deque.peekLast()]);
            }
            deque.addLast(i);
        }

        while (!deque.isEmpty()){
            hashMap.put(nums2[deque.pollLast()], deque.isEmpty() ? -1 : nums2[deque.peekLast()]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length ; i++) {
                int num = hashMap.get(nums1[i]);
                res[i] = num;
        }
        return res;
    }
}
