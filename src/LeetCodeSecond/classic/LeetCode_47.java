package LeetCodeSecond.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/9/18 9:38
 * @Description:
 */
public class LeetCode_47 {
    boolean[] visited;
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        LinkedList<Integer> path = new LinkedList<>();
        dfs(nums, path);
        return res;
    }
    public void dfs(int[] nums, LinkedList<Integer> path){
        if (nums.length == path.size()){
            ArrayList<Integer> list = new ArrayList<>(nums.length);
            for (Integer integer : path) {
                list.add(integer);
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if (!visited[i]){
                if (i > 0 && nums[i] == nums[i-1] && visited[i-1]){
                    continue;
                }
                path.addLast(nums[i]);
                visited[i] = true;
                dfs(nums, path);
                path.removeLast();
                visited[i] = false;
            }
        }
    }
}
