package LeetCodeSecond.tree;

import data_structure.hash.MyHashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/7/21 16:28
 * @Description:
 */
public class LeetCode_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
       return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int first, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (first > end){
            nodes.add(null);
            return nodes;
        }
        for (int i = first; i <= end ; i++) {
            List<TreeNode> leftNodes = generateTrees(first, i-1);
            List<TreeNode> rightNodes = generateTrees(i + 1, end);
            for (TreeNode left: leftNodes) {
                TreeNode node = new TreeNode(i);
                node.left = left;
                for (TreeNode right: rightNodes) {
                    node.right = right;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }
}
