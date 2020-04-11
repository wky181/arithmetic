package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/3/2 0:08
 * @Description:
 */
public class LeetCode_257 {
    public static void main(String[] args) {

    }

    List<String> list = new LinkedList<>();

    public List<String> binaryTreePaths1(TreeNode root) {
        paths(root, "");
        return list;
    }

    public void paths(TreeNode root, String str) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(str+""+root.val);
        }
        paths(root.left, str + "->" + root.val);
        paths(root.right, str + "->" + root.val);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> strings = new ArrayList<>();
        if (root == null){
            return strings;
        }
        if (root.left == null && root.right == null) {
           strings.add(root.val+"");
           return strings;
        }
        List<String> left = binaryTreePaths(root.left);
        for (int i = 0; i < left.size() ; i++) {
            strings.add(root.val + "->" + left.get(i));
        }
        List<String> right = binaryTreePaths(root.right);
        for (int i = 0; i < left.size() ; i++) {
            strings.add(root.val + "->" + right.get(i));
        }
        return strings;
    }
}
