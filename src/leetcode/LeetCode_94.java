package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/18 22:56
 * @Description:
 */
public class LeetCode_94 {
    public static void main(String[] args) {

    }
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
    //使用栈来实现中序遍历
    public List<Integer> inorderTraversal1(TreeNode root) {
            if (root == null){
                return list;
            }
            Stack<Command> stack = new Stack<>();
            stack.push(new Command("go",root));
            Command command ;
            while (!stack.isEmpty()){
                command = stack.pop();
                if ("print".equals(command.s)){
                    list.add(command.node.val);
                }else {
                    if (command.node.right != null ){
                        stack.push(new Command("go",command.node.right));
                    }
                    if (command.node.left != null){
                        stack.push(new Command("go",command.node.left));
                    }
                        stack.push(new Command("print",command.node));
                }
            }
            return list;

    }
    class Command{
        public Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
        String s;
        TreeNode node;
    }
}
