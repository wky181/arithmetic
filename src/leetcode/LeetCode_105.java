package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/3/11 17:18
 * @Description:
 */
public class LeetCode_105 {
    int[] preorder;
    int[] inorder;
    int perindex = 0;

    HashMap<Integer,Integer> inorderHashMap = new HashMap<>();
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorder = this.preorder;
        inorder = this.inorder;
        for (int i = 0; i < inorder.length ; i++) {
            inorderHashMap.put(inorder[i],i);
        }
        return build(0,preorder.length-1);

    }
    // 返回这段先序遍历序列重建后的根节点
    public TreeNode build(int left, int right) {
        if (left > right){
            return null;
        }
        TreeNode root = new TreeNode(preorder[perindex]);
        int orderIndex = inorderHashMap.get(preorder[perindex]);
        perindex++;
        root.left = build(left,orderIndex-1);
        root.right = build(orderIndex+1,right);
        return  root;
    }

}
