package demo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/9/27 10:45
 * @Description:
 */
public class W2 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int maxProfit = -1;
        Deque<Node> deque = new LinkedList<>();
        deque.offer(new Node(0,1));
        deque.offer(new Node(0,2));
        deque.offer(new Node(0,3));
        deque.offer(new Node(0,4));
        int index = 0;
        int waitNum = customers[index++];
        int curNum = 0;
        while (true){

        }
    }
    public class Node{
        int hc;
        boolean visited;
        int number;

        public Node(int hc, int number) {
            this.hc = hc;
            this.number = number;
        }
    }
}
