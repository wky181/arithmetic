package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/10 14:31
 * @Description:
 */
public class LeetCode_78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new LeetCode_78().subsets(nums);
        System.out.println(subsets.toString());
    }

    List<List<Integer>> lists;

    public List<List<Integer>> subsets(int[] nums) {
        lists = new LinkedList<>();
        dfs(nums,new ArrayDeque<Integer>(),0);
        return lists;
    }
    public void dfs(int[] nums, Deque<Integer> deque, int index) {
        lists.add(new ArrayList<>(deque));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            deque.addLast(nums[i]);
            dfs(nums, deque, i + 1);
            deque.removeLast();
        }
    }
}
