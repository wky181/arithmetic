package LeetCodeSecond.tree;

/**
 * @Author: wky233
 * @Date: 2020/7/6 10:43
 * @Description:
 */
public class LeetCode_144 {
    public void flatten(TreeNode root) {
         build(root);
    }
    // 函数意义 返回以root为根的二叉树 转换为链表后的表头
    public TreeNode build(TreeNode root) {
        if (root == null){
            return root;
        }
        // 左子树转化链表
        TreeNode left = build(root.left);
        root.left = null;
        // 右子树转化链表
        TreeNode right = build(root.right);
        if (left != null){
            root.right = left;
            TreeNode temp = left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
        }
        return root;
    }
    // 迭代写法
    public void flatten1(TreeNode root) {
        while (root != null){
            if (root.left == null){
                // 直接一个节点
                root = root.right;
            }else {
                // 找左子树的最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                //将原来的右子树接到左子树最右边的节点
                pre.right = root.right;
                // 将左子树插到右子树前面
                root.right = root.left;
                root.left = null;
                // 考虑下一个结点
                root = root.right;
            }
        }
    }
    // 后序遍历的
    // 就不会有丢失孩子的问题了，因为更新当前的右指针的时候，当前节点的右孩子已经访问过了。
    TreeNode pre = null;
    public void flatten2(TreeNode root) {
        if (root != null){
            flatten(root.right);
            flatten(root.left);
            root.right = pre;
            pre = root;
            root.left = null;
        }
    }
}
