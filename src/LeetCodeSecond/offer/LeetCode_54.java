package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/6/30 14:59
 * @Description:
 */
public class LeetCode_54 {
    int var, k;
    public int kthLargest(TreeNode root, int k) {
       order(root);
       return var;
    }
    public void order(TreeNode root) {
        if (root != null){
            order(root.right);
            // 这一个很重要
            if (k == 0){
                return;
            }
            if (--k == 0){
                var = root.val;
            }
            order(root.left);

        }
    }
}
