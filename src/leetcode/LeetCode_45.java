package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/3/31 14:02
 * @Description:
 */
public class LeetCode_45 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,1,1};
        int jump = new LeetCode_45().jump2(nums);
        System.out.println(jump);
    }
    int[] dp ;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,nums.length);
        return slove(nums,0);
    }
    // 使用动态规划发现超时
    public int slove(int[] nums, int index) {
        if (index >= nums.length -1) {
            return 0;
        }
        if (dp[index] != nums.length){
            return dp[index];
        }
        int steps = nums[index];
        int min = nums.length;
        for (int i = 1; i <= steps; i++) {
           min =  Math.min(min, slove(nums, index + i) +1);
        }
        dp[index] = min;
        return min;
    }
    //使用贪心算法来解
    public int jump1(int[] nums) {
        // 每次起跳点的结束点
        int end = 0;
        // 最远的长度
        int fastpath = 0;
        // 跳跃次数
        int jump =0;
        // nums.length -1 是到达最后一个点了，不需要再计算了。
        for (int i = 0; i < nums.length-1 ; i++) {
            fastpath = Math.max(fastpath,i+nums[i]);
            //起跳点和结束点相同，开始起跳,调到最远的长度。
            if (i == end){
                end = fastpath;
                jump++;
            }
        }
        return jump;
    }
    //使用BFS来做
    public int jump2(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(0,nums[0],0));
        boolean[] visited = new boolean[nums.length];
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size ; i++) {
                Node node = deque.poll();
                int newIndex = node.index;
                visited[newIndex] = true;
                if (newIndex >= nums.length-1){
                    return node.step + 1;
                }
                for (int j = node.count; j >= 1  ; j--) {
                    if (newIndex + j >= nums.length-1){
                        return node.step + 1;
                    }
                    if (!visited[newIndex + j]) {
                        deque.offer(new Node(newIndex + j, nums[newIndex + j], node.step + 1));
                    }
                }
            }
        }
        return 0;
    }
    class Node{
        int index;
        int count;
        int step;

        public Node(int index, int count,int step) {
            this.index = index;
            this.count = count;
            this.step = step;
        }
    }
    //使用贪心算法来解
    public int jump3(int[] nums) {
       int end = 0;
       int maxPath  = 0;
       int jump = 0;
        for (int i = 0; i < nums.length-1 ; i++) {
            maxPath = Math.max(maxPath, i +  nums[i]);
            if (i == end){
                end = maxPath;
                jump++;
            }
        }
        return jump;
    }
}
