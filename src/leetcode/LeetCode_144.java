package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/19 10:59
 * @Description:
 */
public class LeetCode_144 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        new LeetCode_144().preorderTraversal(treeNode);
    }
    ArrayList<Integer> arrayList = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root != null){
            System.out.println(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return arrayList;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(true, root));
        Command command;
        while (!stack.isEmpty()) {
            command = stack.pop();
            if (!command.isGo) {
                arrayList.add(command.node.val);
            } else {
                if (command.node.right != null) {
                    stack.push(new Command(true,command.node.right));
                }
                if (command.node.left!= null) {
                    stack.push(new Command(true,command.node.left));
                }
                stack.push(new Command(false,command.node));
            }
        }
        return arrayList;
    }

    class Command {
        public Command(boolean isGo, TreeNode node) {
            this.isGo = isGo;
            this.node = node;
        }
        boolean isGo;
        TreeNode node;
    }
}
