package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/4/6 23:45
 * @Description:
 */
public class LeetCode_39 {


    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = new LeetCode_39().combinationSum(candidates, 7);
        System.out.println(lists);
    }
    List<List<Integer>> lists;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new LinkedList<>();
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        backtrace2(candidates,0,target,path);
        return lists;
    }
    public void  backtrace(int[] candidates, int target, Deque<Integer> path) {
        if (target < 0 || candidates == null){
            return;
        }
        if (target == 0){
            lists.add(new ArrayList<>(path));
        }
        for (int i = 0; i  < candidates.length ; i++) {
            // 如果当前要减的值，比最后已选的值要小，要么是重复的结果，要么根本不是结果 比如 223 232
            // 当前已选的分别是 22 和 23 在选最后一个元素时出现了重复结果。
            if (!path.isEmpty() && candidates[i] < path.peekLast()){
                continue;
            }
            path.addLast(candidates[i]);
            backtrace(candidates, target - candidates[i] ,path);
            path.removeLast();
        }
    }
    // 通过排序数组进一步优化性能
    public void  backtrace1(int[] candidates, int target, Deque<Integer> path) {
        if (target < 0 || candidates == null){
            return;
        }
        if (target == 0){
            lists.add(new ArrayList<>(path));
        }
        for (int i = 0; i  < candidates.length ; i++) {
            // 如果当前要减的值，比最后已选的值要小，要么是重复的结果，要么根本不是结果 比如 223 232
            // 当前已选的分别是 22 和 23 在选最后一个元素时出现了重复结果。
            if (!path.isEmpty() && candidates[i] < path.peekLast()){
                continue;
            }
            // 因为当前元素减完后-1了，而以后的要减的元素只会更大，所以直接跳出循环，不考虑后面元素
            if (target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            backtrace(candidates, target - candidates[i] ,path);
            path.removeLast();
        }
    }
    public void  backtrace2(int[] candidates, int index, int target, Deque<Integer> path) {
        if (target < 0 || candidates == null){
            return;
        }
        if (target == 0){
            lists.add(new ArrayList<>(path));
        }
        for (int i = index; i  < candidates.length ; i++) {
            // 如果当前要减的值，比最后已选的值要小，要么是重复的结果，要么根本不是结果 比如 223 232
            // 当前已选的分别是 22 和 23 在选最后一个元素时出现了重复结果。
            if (!path.isEmpty() && candidates[i] < path.peekLast()){
                continue;
            }
            // 因为当前元素减完后-1了，而以后的要减的元素只会更大，所以直接跳出循环，不考虑后面元素
            if (target - candidates[i] < 0){
                break;
            }
            path.addLast(candidates[i]);
            backtrace2(candidates,i, target - candidates[i] ,path);
            path.removeLast();
        }
    }
}
