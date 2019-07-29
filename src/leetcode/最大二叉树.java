package leetcode;
/**
 * @author 武凯焱
 * @date 2019/7/27 16:42
 * @Description:
 */
public class 最大二叉树 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        System.out.println( constructMaximumBinaryTree(nums));
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        return getTreeNode(nums,0,nums.length-1);
    }
    public static TreeNode getTreeNode(int[] nums,int i,int j){
        if (i>j){
            return null;
        }
            int index = getMax(nums,i,j);
            TreeNode root  = new TreeNode(nums[index]);
            //寻找root左子树
            root.left = getTreeNode(nums,i,index-1);
            //寻找root右子树
            root.right = getTreeNode(nums,index+1,j);
            return root;
    }
    public static int getMax(int[] nums,int i,int j){
        int max  = nums[i];
        int maxIndex = i;
        for (int k = i+1; k <=j ; k++) {
            if (nums[k]>max){
                max = nums[k];
                maxIndex = k;
            }
        }
        return  maxIndex;
    }


}

