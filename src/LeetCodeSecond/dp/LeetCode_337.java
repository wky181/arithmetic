package LeetCodeSecond.dp;

import LeetCodeSecond.tree.TreeNode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/8/5 23:12
 * @Description:
 */
public class LeetCode_337 {
    HashMap<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }else if (memo.containsKey(root)){
            return memo.get(root);
        }
        int doRob = root.val;
        if (root.left != null){
            doRob += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null){
            doRob += rob(root.right.left) + rob(root.right.right);
        }
        int notRob = rob(root.left) + rob(root.right);
        int res = Math.max(doRob, notRob);
        memo.put(root,res);
        return res;
    }
}
