package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/8/24 16:42
 * @Description:
 */
public class Demo {
    public int findMaxLength(TreeNode node){
        if (node == null){
            return 0;
        }
        int l = findMaxLength(node.left);
        int r = findMaxLength(node.right);
        return Math.max(l,r) + 1;
    }
}
