package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/3/23 0:02
 * @Description:
 */
public class LeetCode_337 {
    HashMap<TreeNode,Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int doRob = root.val;
        if (root.left != null) {
            doRob += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            doRob = rob(root.right.left) + rob(root.right.right);
        }
        int noRob = rob(root.left) + rob(root.right);
        int res =  Math.max(doRob,noRob);
        memo.put(root,res);
        return res;
    }
    public int rob1(TreeNode root) {
        int[] dp = dp(root);
        return Math.max(dp[0],dp[1]);
    }
    int[] dp(TreeNode root){
        if (root == null){
            return new  int[] {0,0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        //arr用来记录当前抢劫root和不抢劫root的最大值
        int[] arr = new int[2];
        // 抢，下家就不能抢了
        int rob = root.val + left[1] + right[1];
        //不抢，就比较得出左右子树最大值相加。
        int not_rob = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        arr[0] = rob;
        arr[1] = not_rob;
        return arr;
    }
}
