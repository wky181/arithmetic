package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/10 13:53
 * @Description:
 */
public class LeetCode_216 {
    public static void main(String[] args) {
        List<List<Integer>> lists = new LeetCode_216().combinationSum3(3, 9);
        System.out.println(lists.toString());
    }
    List<List<Integer>> lists;
    public List<List<Integer>> combinationSum3(int k, int n) {
        lists = new LinkedList<>();
        if (k <=0 || n <=0){
            return lists;
        }
        dfs(k,1,new ArrayDeque<Integer>(),n);
        return lists;
    }
    public void dfs(int k, int index, Deque<Integer> path, int n) {
        if (k == 0 && n == 0){
            lists.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < 10 ; i++) {
            if (n - i < 0 || k <= 0){
                continue;
            }
            path.addLast(i);
            dfs(k-1,i+1,path,n-i);
            path.removeLast();
        }
    }
}
