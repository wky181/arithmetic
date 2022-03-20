package LeetCodeSecond.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/9/20 11:40
 * @Description:
 */
public class LeetCode_78 {
    List<List<Integer>> lists;
    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        dfs(new LinkedList<>(), 0, nums);
        return lists;
    }
    public void dfs(Deque<Integer> path, int index,int[] nums){
        lists.add(new ArrayList<>(path));
        if (index == nums.length){
            return;
        }
        for (int i = index; i < nums.length ; i++) {
            // 选择
            path.addLast(nums[i]);
            // 递归
            dfs(path, index + 1, nums);
            // 回溯
            path.removeLast();
        }
    }
}
