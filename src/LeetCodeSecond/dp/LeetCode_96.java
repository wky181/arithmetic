package LeetCodeSecond.dp;

/**
 * @Author: wky233
 * @Date: 2020/7/5 23:46
 * @Description:
 */
public class LeetCode_96 {
    int[][] dp;
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        dp = new int[n + 1][n + 1];
        return method(1, n);

    }

    public int method(int left, int right) {
        // 空二叉树也是一颗二叉树
        if (left >= right) {
            return 1;
        } else if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int count = 0;
        for (int i = left; i <= right; i++) {
            int leftCount = method(left, i - 1);
            int rightCount = method(i + 1, right);
            count += leftCount * rightCount;
        }
        dp[left][right] = count;
        return count;
    }

    // 卡特兰数
    // 假设n个节点存在二叉排序树的个数为G(n)，令f(i)为以i为根的二叉搜索树的个事故
    //G(n) = f(1) + f(2) + f(3)
    // 当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
    //f(i) = G(i - 1) * G(n - i)
    //G(n) = G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        // G(0)
        dp[0] = 1;
        // G(1)
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        if (n == 1) {
            return 1;
        }
        dp = new int[n + 1][n + 1];
        return treeCount(1, n);
    }
    public int treeCount(int left, int right){
        if (left >= right){
            return 1;
        } else if (dp[left][right] != 0) {
            return dp[left][right];
        }
        int count = 0;
        for (int i = left; i <= right ; i++) {
            int leftCount = treeCount(left, i-1);
            int rightCount = treeCount(i+1, right);
            count += leftCount * rightCount;
        }
        dp[left][right] = count;
        return count;
    }

}
