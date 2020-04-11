package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/3/6 13:53
 * @Description:
 */
public class LeetCode_230 {
    int count;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        help(root,k);
        return res;
    }
    public void help(TreeNode root, int k) {
        if (root != null){
            kthSmallest(root.left , k);
            count++;
            if (count == k){
                res = root.val;
                return ;
            }
            kthSmallest(root.right, k);
        }

    }
}
