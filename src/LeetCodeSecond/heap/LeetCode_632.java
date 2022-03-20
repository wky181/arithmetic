package LeetCodeSecond.heap;


import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: wky233
 * @Date: 2020/8/1 22:35
 * @Description:
 */
public class LeetCode_632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.list.get(o1.index).compareTo(o2.list.get(o2.index)));
        for (List<Integer> list: nums) {
            priorityQueue.offer(new Node(list));
        }
        int begin = 0;
        int end = 0;
        while (!priorityQueue.isEmpty()){
            Node poll = priorityQueue.poll();
            if (poll.index + 1 < poll.list.size()){
                poll.index++;
                priorityQueue.offer(poll);
            }
        }
        return new int[]{begin, end};
    }
    private class Node{
        List<Integer> list;
        int index;
        public Node(List<Integer> list) {
            index = 0;
            this.list = list;
        }
    }
}
