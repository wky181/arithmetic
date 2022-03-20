package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/5/7 22:10
 * @Description:
 */
public class LeetCode_572 {
    public static void main(String[] args) {

    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null || s == null){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(s);
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node.val == t.val && isTrue(s,t)){
                return true;
            }
            if (node.left != null){
                deque.offer(node.left);
            }
            if (node.right != null){
                deque.offer(node.right);
            }
        }
        return false;
    }
    public boolean isTrue(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        }
        else if (s == null || t == null) {
            return false;
        }
        return s.val == t.val && isTrue(s.left,t.left) && isTrue(s.right, t.right);
    }
}
