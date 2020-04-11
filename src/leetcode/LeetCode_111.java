package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wky233
 * @Date: 2020/2/27 23:02
 * @Description:
 */
public class LeetCode_111 {
    public static void main(String[] args) {

    }
    public int minDepth(TreeNode root) {
       return min(root);
    }
    public int min(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 判断下当前节点是否已到尽头 最低深度是指根节点到叶子结点的最小长度
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left != null && root.right != null){
           return Math.min(minDepth(root.left) , minDepth(root.right)) +1 ;
        }else if (root.left == null){
            return minDepth(root.right);
        }else {
            return minDepth(root.left);
        }
    }
}
