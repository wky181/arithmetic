package swordoffer;

import LeetCodeSecond.tree.TreeNode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/8/27 9:16
 * @Description:
 */
public class offer_7 {
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> inorderMap;
    int perIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(0, preorder.length-1);
    }
    public TreeNode build(int left, int right) {
        if (left > right){
            return null;
        }
        int val = preorder[perIndex++];
        TreeNode root = new TreeNode(val);
        Integer orderIndex = inorderMap.get(val);
        root.left = build(left, orderIndex-1);
        root.right = build(orderIndex+1, right);
        return root;
    }
}
