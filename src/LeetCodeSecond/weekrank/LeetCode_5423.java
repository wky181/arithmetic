package LeetCodeSecond.weekrank;

import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author: wky233
 * @Date: 2020/6/13 22:47
 * @Description:
 */
public class LeetCode_5423 {
    public int minSumOfLengths(int[] arr, int target) {
        int[] preNums = new int[arr.length + 1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i-1] + arr[i-1];
        }
        List<Node> list = new ArrayList<>();
        for (int i = 1; i < preNums.length ; i++) {
            Node node = null;
            for (int j = 0; j < i ; j++) {
                if (preNums[i] - preNums[j] == target){
                    node = new Node(j,i);
                }
            }
            if (node != null) {
                add(node, list);
            }
        }
        if (list.size() < 2){
            return -1;
        }else {
            Node node = list.get(0);
            Node node1 = list.get(1);
            return node.right - node.left + node1.right - node1.left;
        }
    }
    private void add (Node node, List<Node> list){
        int length = node.right  - node.left;
        for (int i = list.size()-1; i >= 0 ; i--) {
            Node nodels = list.get(i);
            if (node.left < nodels.right && length <= nodels.right - nodels.left  ){
                list.remove(i);
                continue;
            }
            if (list.size() >= 2 && length >= nodels.right - nodels.left ){
                return;
            }
            else if(list.size() >= 2 && length < nodels.right - nodels.left ){
                list.remove(i);
            }
        }
        list.add(node);
    }
    private class Node{
        int left ;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    // 前缀和 + dp + hash
    public int minSumOfLengths1(int[] arr, int target) {
        // 记录每个前缀和与它结尾的下标
        HashMap<Integer,Integer> perNumIndex = new HashMap<>();
        // 初始化
        perNumIndex.put(0,-1);
        // 记录下标i之前包括i 和为target的子数组的最小长度
        int[] dp = new int[arr.length];
        int t = 0;
        int min = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            t += arr[i];
            perNumIndex.put(t,i);
            int tPre = t - target;
            if (perNumIndex.containsKey(tPre)){
                int perIndex = perNumIndex.get(tPre);
                int length = i - perIndex;
                if (min != 0){
                    min = Math.min(min,length);
                }else {
                    min = length;
                }
                if (perIndex != -1 && dp[perIndex] != 0){
                    // 此时一定出现了两个不重叠子数组且和为target
                    ans = Math.min(ans,dp[perIndex] + length);
                }
            }else {
                dp[i] = min;
            }
        }
        if (ans != Integer.MAX_VALUE){
            return ans;
        }else {
            return -1;
        }
    }
    List<Pair> list = new ArrayList();
    // 滑动窗口 + 排序 + 剪枝
    public int minSumOfLengths2(int[] arr, int target) {
        int left =  0;
        int right = 0;
        int windowSum = 0;
        while (right < arr.length){
            windowSum += arr[right];
            right++;
            while (windowSum > target){
                windowSum -= arr[left];
                left++;
            }
            if (windowSum == target){
                list.add(new Pair(right - left,left,right));
            }
        }
        int ans = Integer.MAX_VALUE;
        Collections.sort(list,(p1,p2) -> p1.length - p2.length);
        for (int i = 0; i < list.size() ; i++) {
            Pair pair = list.get(i);
            if (pair.length * 2 >= ans  ){
                break;
            }
            for (int j = i+1; j < list.size() ; j++) {
                Pair pair1 = list.get(j);
                if (pair.left < pair1.left && pair.right > pair1.left){
                    continue;
                }
                if (pair1.left < pair.left && pair1.right > pair.left){
                    continue;
                }
                ans = Math.min(ans,pair.length + pair1.length);
                break;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private class Pair{
        int length ;
        int left;
        int right;

        public Pair(int length, int left, int right) {
            this.length = length;
            this.left = left;
            this.right = right;
        }
    }
}
