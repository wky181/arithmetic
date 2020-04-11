package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wky233
 * @Date: 2020/2/24 23:21
 * @Description: 从n到0，每个数字代表一个节点
 * 如果x和y相差一个完全平方数就是一条边
 * 在这个无权图中找出从 n 到 0 的最短路径。
 */
public class LeetCode_279 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_279().numSquares1(12));
    }

    class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        queue.offer(new Node(n, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int val = node.val;
            for (int i = 1; ; i++) {
                int num = val - i * i;
                if (num < 0) {
                    break;
                }
                if (num == 0) {
                    return node.step + 1;
                }
                if (!visit[num]) {
                    queue.offer(new Node(num, node.step + 1));
                    visit[num] = true;
                }
            }
        }
        return 0;
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0 ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] +1);
            }
        }
        return dp[n];
    }

}
