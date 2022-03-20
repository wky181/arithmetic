package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

import java.util.*;

/**
 * @Author: wky233
 * @Date: 2020/6/23 22:00
 * @Description:
 */
public class LeetCode_32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        // BFS + 双端队列

        boolean nixu = false;
        while (!deque.isEmpty()){
            int size = deque.size();
            LinkedList<Integer> list  = new LinkedList<>();
            while (size > 0){
                TreeNode node = deque.poll();
                // BFS 这一层是逆序就采用头插添加，否则采用尾插添加
                if (nixu){
                    list.offerFirst(node.val);
                }else {
                    list.addLast(node.val);
                }
                if (node.left != null){
                    deque.offer(node.left);
                }
                if (node.right != null){
                    deque.offer(node.right);
                }
                size--;
            }
            nixu = !nixu;
            res.add(list);
        }
        return res;
    }
}
