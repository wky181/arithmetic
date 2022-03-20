package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/4/24 23:22
 * @Description:
 */
public class LeetCode_650 {
    public int minSteps(int n) {
        Deque<Node> deque = new LinkedList<>();
        deque.offer(new Node(1,0,0));
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size ; i++) {
                Node node = deque.poll();
                if (node.value == n){
                    return node.count;
                }
                // 拷贝剪切板上的值
                if (node.copy > 0 && node.value + node.copy <= n){
                    deque.offer(new Node(node.value + node.copy,node.copy,node.count+1));
                }
                // 复制到剪切板上
                if (node.count <= n) {
                    deque.offer(new Node(node.value, node.value, node.count + 1));
                }

            }
        }
        return -1;
    }
    private class Node{
        int  value;
        int  copy;
        int count;

        public Node(int value, int copy, int count) {
            this.value = value;
            this.copy = copy;
            this.count = count;
        }
    }
}
