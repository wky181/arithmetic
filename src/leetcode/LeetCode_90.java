package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/10 15:02
 * @Description:
 */
public class LeetCode_90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> lists = new LeetCode_90().subsetsWithDup(nums);
        System.out.println(lists.toString());
    }

    List<List<Integer>> lists;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        lists = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        //注意排序
        Arrays.sort(nums);
        dfs(nums, new ArrayDeque<Integer>(), used, 0);
        return lists;
    }

    public void dfs(int[] nums, Deque<Integer> path, boolean[] used, int index) {
        lists.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, path, used, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }
}
