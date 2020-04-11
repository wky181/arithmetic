package leetcode;

import java.util.HashMap;

/**
 * @Author: wky233
 * @Date: 2020/3/11 20:33
 * @Description:
 */
public class LeetCode_106 {
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> afterHash = new HashMap<Integer, Integer>();
    int after = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null){
            return null;
        }
        if(inorder.length != postorder.length){
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; i++){
            afterHash.put(inorder[i],i);
        }
        after = postorder.length-1;
        return helper(0,inorder.length);
    }
    public TreeNode helper(int left, int right){
        if(left == right){
            return null;
        }
        int value = postorder[after];
        TreeNode root = new TreeNode(value);
        int index = afterHash.get(value);
        after--;
        root.right = helper(index+1,right);
        root.left = helper(left,index);
        return root;
    }
}
