package LeetCodeSecond.tree;

import java.util.Map;

/**
 * @Author: wky233
 * @Date: 2020/6/23 10:35
 * @Description: 题意就是返回两个任意节点连接起来的路径的最大和
 */
public class LeetCode_124 {
    // 不取0防止节点全是负的
    int maxPaths = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return maxPaths;
    }
    // 函数意义返回以当前节点为根节点的最大路径和
    public int max(TreeNode root) {
        if (root == null){
            return 0;
        }
        // 左子树最大路径和 最小为0表示不使用
        int left = max(root.left);
        // 右子树最大路径和 最小为0表示不使用
        int right = max(root.right);
        // 这个就是根 + 左、 根 + 右、 根 + 左 + 右 的最大值
        // 左右都是单线的 根节点可以充当桥梁
        int paths = left + right + root.val;
        // 与全局比较
        maxPaths = Math.max(paths,maxPaths);
        // 只能选择走左边和右边一条，选择最大的, 如果结果为负数返回0，表示不走这个路径了
        return Math.max(0,Math.max(left,right) + root.val);
    }
}
