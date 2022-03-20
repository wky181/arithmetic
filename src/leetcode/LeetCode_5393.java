package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/26 10:52
 * @Description:
 */
public class LeetCode_5393 {

    // 暴力深搜超时
    public int maxScore(int[] cardPoints, int k) {
        return sort(cardPoints,0,0,cardPoints.length-1,k);
    }

    public int sort(int[] cardPoints, int res, int left, int right, int k) {
        if (k == 0){
            return res;
        }
        int l = sort(cardPoints, res + cardPoints[left], left+1, right,k-1);
        int r = sort(cardPoints,res + cardPoints[right], left, right-1, k-1);
        return Math.max(l,r);
    }

    // 通过前缀和来求
    public int maxScore1(int[] cardPoints, int k) {
        int[] perSums = new int[cardPoints.length + 1];
        for (int i = 0; i < cardPoints.length; i++) {
            perSums[i+1] = perSums[i] + cardPoints[i];
        }
        int len = cardPoints.length;
        int max = -1;
        for (int i = 0; i <= k ; i++) {
            max =  Math.max(max, perSums[i] + perSums[len] - perSums[len - (k-i)]);
        }
        return max;
    }
    // 滑动窗口 逆向思维求长度为k的子数组的最小和
    public int maxScore2(int[] cardPoints, int k) {
        int windowNums = 0;
        for (int i = 0; i < k ; i++) {
            windowNums += cardPoints[i];
        }
        k = cardPoints.length - k;
        int sums = windowNums;
        for (int i = k; i < cardPoints.length ; i++) {
            sums += cardPoints[i];
        }
        int min = windowNums;
        for (int i = 0; i < cardPoints.length - k ; i++) {
            windowNums =  windowNums - cardPoints[i] + cardPoints[k+i];
            min = Math.min(min,windowNums);
        }
        return sums - min;
    }

}
