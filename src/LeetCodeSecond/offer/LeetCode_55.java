package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;
import bluebridgecup_course.class_03.最小可用id;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/6/30 15:47
 * @Description:
 */
public class LeetCode_55 {
    // 递归
    public int maxDepth(TreeNode root) {
        return root == null? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    // 迭代
    public int maxDepth1(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        deque.offer(root);
        int count = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
                TreeNode top = deque.poll();
                if (top.left != null){
                    deque.offer(top.left);
                }
                if (top.right != null){
                    deque.offer(top.right);
                }
                size--;
            }
            count++;
        }
        return count;
    }
}
