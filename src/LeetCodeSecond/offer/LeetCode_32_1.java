package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/20 15:03
 * @Description:
 */
public class LeetCode_32_1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            List<Integer> nodes = new ArrayList();
            while (size > 0){
                TreeNode top = deque.poll();
                nodes.add(top.val);
                if (top.left != null){
                    deque.offer(top.left);
                }
                if (top.right != null){
                    deque.offer(top.right);
                }
                size--;
            }
            list.add(nodes);
        }
       return list;
    }
}
