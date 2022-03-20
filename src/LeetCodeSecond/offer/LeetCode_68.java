package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/7/3 0:27
 * @Description:
 */
public class LeetCode_68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }
        if (root.val > p.val &&  root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (root.val < p.val &&  root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            if (root.val > p.val &&  root.val > q.val){
                root = root.left;
            }
            else if (root.val < p.val &&  root.val < q.val){
                root = root.right;
            }
            else {
                break;
            }
        }
        return root;
    }
}
