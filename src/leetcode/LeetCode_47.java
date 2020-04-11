package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/6 1:32
 * @Description:
 */
public class LeetCode_47 {
    public static void main(String[] args) {
        int[] nums = {3,3,0,3};

        List<List<Integer>> lists = new LeetCode_47().permuteUnique(nums);
        for (List list: lists) {
            System.out.println(list.toString());
        }
    }
    List<List<Integer>> lists;
    public List<List<Integer>> permuteUnique(int[] nums) {
        lists = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, new LinkedList<Integer>(), used);
        return lists;
    }
    public void backtrace(int[] nums, Deque<Integer> path, boolean[] used){
        if (path.size() == nums.length){
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                if ( i > 0 && nums[i] == nums[i-1] && !used[i-1] ){
                    continue;
                }
                used[i] = true;
                path.addLast(nums[i]);
                backtrace(nums,path,used);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
