package test;

import LeetCodeSecond.tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/9/14 21:01
 * @Description:
 */
public class T58 {
    public ArrayList<ArrayList<Integer>> printNode (TreeNode node) {
        // write code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(node);
        while (!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList();
            while (size > 0){
                TreeNode poll = deque.poll();
                list.add(poll.val);
                if (poll.left != null){
                    deque.offer(poll.left);
                }
                if (poll.right != null){
                    deque.offer(poll.right);
                }
                size--;
            }
            lists.add(list);
        }
        return lists;
    }
}
