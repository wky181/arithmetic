package LeetCodeSecond.offer2;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/9/16 22:43
 * @Description:
 */
public class offer68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else if (root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
}
