package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/5/7 23:01
 * @Description:
 */
public class LeetCdoemian_26 {
    public boolean isSubStructure1(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(A);
        while (!deque.isEmpty()){
            TreeNode node = deque.poll();
            if (node.val == B.val && isTrue(node,B)){
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
        else if (s == null){
            return false;
        }else if (t == null){
            return true;
        }
        return s.val == t.val && isTrue(s.left,t.left) && isTrue(s.right, t.right);
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!= null && B != null) && (slove(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    public boolean slove(TreeNode A, TreeNode B){
        if (B == null){
            return true;
        }
        if (A == null || A.val != B.val ){
            return false;
        }
        return slove(A.left, B.left) && slove(A.right,B.right);
    }
}
