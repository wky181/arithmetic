package LeetCodeSecond.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/9/12 21:04
 * @Description: 中序遍历二叉树
 */
public class LeetCode_94 {
    public class Command{
        String s;
        TreeNode node;

        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return res;
        }
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<Command> stack = new Stack<>();
        Command command = new Command("go",root);
        stack.push(command);
        while (!stack.isEmpty()){
            Command top = stack.pop();
            if (top.s.equals("print")){
                //System.out.println(top.node.val);
                res.add(top.node.val);
            }else {
                top.s = "print";
                if (top.node.right != null){
                    stack.push(new Command("go", top.node.right));
                }
                stack.push(top);
                if (top.node.left != null){
                    stack.push(new Command("go", top.node.left));
                }
            }
        }
        return res;
    }
}
