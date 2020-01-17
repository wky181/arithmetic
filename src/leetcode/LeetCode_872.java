package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2019/12/21 14:56
 * @Description:
 */
public class LeetCode_872 {
    ArrayList<Integer> arrayListA = new ArrayList<>();
    ArrayList<Integer> arrayListB = new ArrayList<>();

    public boolean leafSimilar1(TreeNode root1, TreeNode root2) {
        traversalTree(root1, arrayListA);
        traversalTree(root2, arrayListB);
        if (arrayListA.size() != arrayListB.size()) {
            return false;
        } else {
            return arrayListA.equals(arrayListB);
        }

    }

    public void traversalTree(TreeNode treeNode, ArrayList<Integer> arrayList) {
        if (treeNode.left != null) {
            traversalTree(treeNode.left, arrayList);
        } else if (treeNode.right != null) {
            traversalTree(treeNode.right, arrayList);
        } else {
            arrayList.add(treeNode.val);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }
    //先序遍历
    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null)
                leafValues.add(node.val);
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}
