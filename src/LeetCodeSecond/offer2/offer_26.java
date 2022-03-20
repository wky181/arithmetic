package LeetCodeSecond.offer2;

import LeetCodeSecond.tree.TreeNode;

/**
 * @Author: wky233
 * @Date: 2020/9/15 23:04
 * @Description:
 */
public class offer_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null){
            return false;
        }
        return jundge(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right,B);
    }
    public boolean jundge(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return jundge(A.left, B.left) && jundge(A.right, B.right);
    }
}
