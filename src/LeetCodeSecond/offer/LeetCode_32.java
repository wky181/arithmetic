package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/20 14:49
 * @Description:
 */
public class LeetCode_32 {
    public int[] levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
                TreeNode top = deque.poll();
                list.add(top.val);
                if (top.left != null){
                    deque.offer(top.left);
                }
                if (top.right != null){
                    deque.offer(top.right);
                }
                size--;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length ; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
