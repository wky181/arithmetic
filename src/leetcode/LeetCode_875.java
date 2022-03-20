package leetcode;

/**
 * @Author: wky233
 * @Date: 2020/4/30 15:49
 * @Description:
 */
public class LeetCode_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = piles[0];
        for (int i: piles) {
            right = Math.max(i,right);
        }
        int len = piles.length;
        if (H == piles.length){
            return right;
        }
        while (left < right){
            int mid = (left + right) >>> 1;
            // 统计大于mid，珂珂需要吃的次数
            int sum = 0;
            // 统计大于mid个数
            int count = 0;
            for (int num : piles) {
                if (num > mid){
                   sum += num / mid + 1;
                   count++;
                }
            }
            // len - count表示 速度为mid时，一次就可吃完的堆的个数
            if (sum + len - count > H){
                // mid太小，需要加快速度
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
