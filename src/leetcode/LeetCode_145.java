package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: wky233
 * @Date: 2020/2/19 13:06
 * @Description:
 */
public class LeetCode_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
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
                stack.push(new Command(false,command.node));

                if (command.node.right != null) {
                    stack.push(new Command(true,command.node.right));
                }
                if (command.node.left!= null) {
                    stack.push(new  Command(true,command.node.left));
                }

            }
        }
        return arrayList;
    }
    class Command{

        boolean isGo;
        TreeNode node;
        public Command(boolean isGo, TreeNode node) {
            this.isGo = isGo;
            this.node = node;
        }
    }


}
