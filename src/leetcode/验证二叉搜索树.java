package leetcode;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 武凯焱
 * @date 2019/3/10 10:21
 * @Description:
 */
public class 验证二叉搜索树 {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            return true;
        }
        public void inorder(TreeNode node,List<Integer> list){
            if (node==null) return;
            inorder(node.getChildAt(0),list);
          //  list.add(node.)

        }
    }
}
