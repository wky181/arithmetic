package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/6 10:46
 * @Description:
 */
public class LeetCode_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val < key){
           root.right =  deleteNode(root.right,key);
        }else if (root.val > key){
            root.left = deleteNode(root.left, key);
        }else {
            if (root.left == null && root.right == null) {
                root = null;
            }else if (root.right != null){
                root.val = afterNode(root);
                root.right = deleteNode(root.right,root.val);
            }else {
                root.val = afterNode(root);
                root.left = deleteNode(root.left,root.val);
            }
        }
        return root;
    }
    public int beforeNode(TreeNode root) {
     root = root.left;
     while (root.right != null){
         root = root.right;
     }
     return root.val;
    }
    public int afterNode(TreeNode root) {
        root = root.right;
        while (root.left != null){
            root = root.left;
        }
        return root.val;
    }
}
