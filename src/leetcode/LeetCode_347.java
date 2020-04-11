package leetcode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/2/26 12:33
 * @Description:
 */
public class LeetCode_347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2,2,2, 3};
        int k = 2;
        System.out.println(new LeetCode_347().topKFrequent(nums,k));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 1) + 1);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.nums - o2.nums;
            }
        });
        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(new Node(entry.getKey(), entry.getValue()));
            } else {

                if (!priorityQueue.isEmpty() && entry.getValue() > priorityQueue.peek().nums) {
                    priorityQueue.poll();
                    priorityQueue.offer(new Node(entry.getKey(), entry.getValue()));
                }else if (priorityQueue.isEmpty()){
                    priorityQueue.offer(new Node(entry.getKey(), entry.getValue()));
                }
            }
        }
        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.offerFirst(priorityQueue.poll().number);
        }
        return res;
    }

    class Node {
        Integer number;
        Integer nums;

        public Node(Integer number, Integer nums) {
            this.number = number;
            this.nums = nums;
        }
    }

    }
