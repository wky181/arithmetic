package LeetCodeSecond.offer;

import LeetCodeSecond.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wky233
 * @Date: 2020/6/24 23:42
 * @Description:
 */
public class LeetCode_34 {
        List<List<Integer>> res;
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            res =  new ArrayList<>();
            pathSum(root, 0,sum, new LinkedList<>());
            return res;
        }
        public void pathSum(TreeNode root, int sum, int target, LinkedList<Integer> path) {
            if ( root == null ){
                return;
            }
            else if (root.left == null  && root.right == null && sum+root.val == target){
                path.addLast(root.val);
                LinkedList<Integer> list = new LinkedList<>();
                for (Integer integer: path) {
                    list.addLast(integer);
                }
                res.add(list);
                // 回溯
                path.removeLast();
                return;
            }
            sum += root.val;
            path.addLast(root.val);
            pathSum(root.left,sum,target,path);
            pathSum(root.right,sum,target,path);
            // 回溯
            path.removeLast();
        }
}
