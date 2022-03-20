package LeetCodeSecond.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: wky233
 * @Date: 2020/6/24 0:22
 * @Description:
 */
public class LeetCode_33 {
    // 利用单调栈来解决
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0){
            return false;
        }
        int perNum = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        //倒序遍历整个数组 root right left
        deque.addLast(Integer.MAX_VALUE);
        for (int i = postorder.length-1; i >= 0 ; i--) {
                int num = postorder[i];
             //   if (num)

        }
        return true;
    }
    // 利用递归分治来做
    public boolean verifyPostorder1(int[] postorder) {
        if (postorder == null || postorder.length == 0){
            return false;
        }
        return solve(postorder,0,postorder.length-1);
    }

    // 函数意义返回当前区间内的二叉树是否为二叉搜索树
    public boolean solve(int[] postorder, int i, int j){
        if (i >= j){
            return true;
        }
        int index = i;
        // 遍历区间 根据left right root 先从开始确定左边边界
        while (postorder[index] < postorder[j]){
            index++;
        }
       int left = index-1;
        while (postorder[index] > postorder[j]){
            index++;
        }
        // index == j 左子树的结点都比它小 右子树的节点都比它大 然后递归判断左右子树是否为二叉搜索树
        return index == j && solve(postorder,i,left) && solve(postorder,left+1,j-1);
    }
}
