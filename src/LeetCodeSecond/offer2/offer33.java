package LeetCodeSecond.offer2;

/**
 * @Author: wky233
 * @Date: 2020/9/16 14:23
 * @Description:
 */
public class offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyTree(postorder, 0, postorder.length - 1);
    }
    public boolean verifyTree(int[] postorder, int i, int j){
        if (i >= j){
            return true;
        }
        int root = postorder[j];
        int index = i;
        while (postorder[index] < root){
            index++;
        }
        int left = index - 1;
        while (postorder[index] >= root){
            index++;
        }
        return index == j && verifyTree(postorder, i, left) && verifyTree(postorder,left + 1, j - 1);
    }

}
