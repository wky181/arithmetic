package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/2/27 23:55
 * @Description:
 */
public class LeetCode_100 {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null){
                return true;
            }else if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val){
                return false;
        }
        boolean left = isSameTree(p.left, q.left);
        boolean rigth = isSameTree(p.right, q.right);
        return left && rigth;
    }
}
