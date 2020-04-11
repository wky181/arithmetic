package leetcode;

import bluebridgecup_course.class_03.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/3/2 23:15
 * @Description:
 */
public class LeetCode_113 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = Utils.creatTree(nums);
        List<List<Integer>> lists = new LeetCode_113().pathSum(treeNode, 8);
        System.out.println(lists);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        pathSum(root,sum, new Stack<>(),lists);
        return lists;
    }
    public void pathSum(TreeNode root, int sum, Stack<Integer> stack, List<List<Integer>> res ) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null && sum == root.val){
            LinkedList<Integer> linkedList = new LinkedList();
            for (Integer integer: stack) {
                linkedList.offer(integer);
            }
            linkedList.offer(root.val);
            res.add(linkedList);
            return;
        }
        stack.push(root.val);
        pathSum(root.left,sum - root.val, stack,res);
        pathSum(root.right,sum - root.val, stack,res);
        stack.pop();
    }
}
