package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/5/24 10:52
 * @Description:
 */
public class LeetCode_5418 {
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] paths = new int[10];
        dfs(root,paths);
        return ans  / 2 ;
    }
    public void dfs (TreeNode root, int[] paths) {
        if (root != null && root.left == null && root.right == null ){
            if (jundge(paths)) {
                ans++;
            }
            return;
        }
        else if (root == null){
            return;
        }
        int val =  root.val;
        paths[val]++;
        dfs(root.left,paths);
        dfs(root.right,paths);
        paths[val]--;
    }

    private boolean jundge(int[] paths) {
        int length = 0;
        int ji = 0;
        for (int i = 1; i < paths.length ; i++) {
            length += paths[i];
            if (paths[i] % 2 != 0){
                ji++;
            }
        }
        if (length == 0 || ji > 1){
            return false;
        }
        return true;
    }

}
