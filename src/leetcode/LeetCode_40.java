package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/7 0:45
 * @Description:
 */
public class LeetCode_40 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = new LeetCode_40().combinationSum2(candidates, 8);
        System.out.println(lists.toString());
    }
    List<List<Integer>> lists;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || target <= 0){
            return lists;
        }
        Arrays.sort(candidates);
        lists = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[candidates.length];
        backtrace(candidates,used,0,path,target);
        return lists;
    }
    public void backtrace(int[] candidates, boolean[] used,int index,Deque<Integer> path, int target) {
        if (target == 0){
            lists.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length ; i++) {
            if (!used[i]){
                if (i> 0 &&  candidates[i] == candidates[i-1] && !used[i-1]){
                    continue;
                }
                if (target - candidates[i] < 0){
                    break;
                }
                path.addLast(candidates[i]);
                used[i] = true;
                backtrace(candidates,used,i+1,path,target - candidates[i]);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
